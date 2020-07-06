package com.sparkit.staf.application.service;

import com.sparkit.staf.application.models.request.RenameTestSuiteRequest;
import com.sparkit.staf.application.models.response.GetTestSuiteDetailsResponse;
import com.sparkit.staf.application.models.response.RenameTestSuiteResponse;
import com.sparkit.staf.core.ast.ImportStatement;
import com.sparkit.staf.core.ast.ImportTypes;
import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.parser.SyntaxErrorException;
import com.sparkit.staf.core.runtime.interpreter.SemanticError;
import com.sparkit.staf.core.runtime.loader.IStafCompiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class TestSuiteService {
    private static final String TEST_SUITE_MAIN_FILE = "main.staf";
    private final IStafCompiler stafCompiler;
    @Value("${testDirectory}")
    String testDirectory;

    @Autowired
    public TestSuiteService(IStafCompiler stafCompiler) {
        this.stafCompiler = stafCompiler;
    }

    private static boolean isChild(Path child, String parentText) {
        Path parent = Paths.get(parentText).toAbsolutePath();
        return child.startsWith(parent);
    }

    public GetTestSuiteDetailsResponse getTestSuiteDetails(String project, String testSuiteName) throws IOException, SyntaxErrorException {
        String testSuiteDirectory = getTestSuiteMainFile(project, testSuiteName).getParentFile().getAbsolutePath();
        GetTestSuiteDetailsResponse response = new GetTestSuiteDetailsResponse();
        response.setTestSuite(testSuiteName);
        response.setProject(project);
        response.setTestCases(new ArrayList<>());
        compileTestSuite(project, testSuiteName).values().stream()
                .filter(ast -> Objects.nonNull(ast.getTestCaseDeclarationMap()) && isChild(Paths.get(ast.getFilePath()), testSuiteDirectory))
                .map(ast -> ast.getTestCaseDeclarationMap().values())
                .flatMap(Collection::stream)
                .forEach(testCaseDeclaration -> response.getTestCases().add(
                        response.new TestCase(testCaseDeclaration.getName(),
                                testCaseDeclaration.getFilePath(),
                                testCaseDeclaration.isIgnored(),
                                !testCaseDeclaration.isDefaultOrder() ? String.valueOf(testCaseDeclaration.getOrder()) : "N/A")));
        return response;
    }

    public Map<String, StafFile> compileWithErrors(String project, String testSuiteName) throws IOException {
        String testSuiteMainFilePath = getTestSuiteMainFile(project, testSuiteName).getAbsolutePath();
        StafFile mainScriptAST = null;
        mainScriptAST = stafCompiler.compileWithErrors(testSuiteMainFilePath);
        Map<String, StafFile> testSuiteImportedFilesAST = new HashMap<>();
        testSuiteImportedFilesAST.put(toRelativePath(testSuiteMainFilePath), mainScriptAST);
        String currentDirectoryPath = mainScriptAST.getFilePath().substring(0, mainScriptAST.getFilePath().lastIndexOf('/'));
        if (mainScriptAST.getImports() != null) {
            loadImports(currentDirectoryPath, mainScriptAST, testSuiteImportedFilesAST);
        }
        return testSuiteImportedFilesAST;
    }

    public Map<String, StafFile> compileTestSuite(String project, String testSuiteName) throws IOException {
        String testSuiteMainFilePath = getTestSuiteMainFile(project, testSuiteName).getAbsolutePath();
        StafFile mainScriptAST = stafCompiler.compileWithErrors(testSuiteMainFilePath);
        Map<String, StafFile> testSuiteImportedFilesAST = new HashMap<>();
        testSuiteImportedFilesAST.put(testSuiteMainFilePath, mainScriptAST);
        String currentDirectoryPath = mainScriptAST.getFilePath().substring(0, mainScriptAST.getFilePath().lastIndexOf('/'));
        if (mainScriptAST.getImports() != null) {
            loadImports(currentDirectoryPath, mainScriptAST, testSuiteImportedFilesAST);
        }
        return testSuiteImportedFilesAST;
    }

    public void loadImports(String currentDirectory, StafFile parentFileAST, Map<String, StafFile> testSuiteFilesAST)
            throws IOException {
        for (ImportStatement statement : parentFileAST.getImports()) {
            if (statement.getType() == ImportTypes.BUILT_IN_LIBRARY) {
                continue;
            }
            File directory = new File(currentDirectory);
            File importedFile = new File(directory, statement.getPath().replaceAll("[\"']", ""));
            String importedFileAbsolutePath = importedFile.getCanonicalPath();
            if (!testSuiteFilesAST.containsKey(importedFileAbsolutePath)) {
                StafFile scriptAST;
                try {
                    scriptAST = stafCompiler.compileWithErrors(importedFileAbsolutePath);
                    testSuiteFilesAST.put(toRelativePath(importedFileAbsolutePath), scriptAST);
                    if (scriptAST.getImports() != null) {
                        loadImports(importedFile.getParentFile().getAbsolutePath(), scriptAST, testSuiteFilesAST);
                    }
                } catch (NoSuchFileException e) {
                    if (parentFileAST.getSemanticErrors() == null) {
                        parentFileAST.setSemanticErrors(new ArrayList<>());
                    }
                    parentFileAST.getSemanticErrors().add(new SemanticError(statement.getTokenPosition(), "Invalid import path"));
                }
            }
        }
    }

    public RenameTestSuiteResponse renameTestSuite(RenameTestSuiteRequest renameRequest) {
        RenameTestSuiteResponse response = new RenameTestSuiteResponse();
        String normalizedProjectName = ProjectService.normalizeProjectName(renameRequest.getProjectName());
        File testSuiteDirectory = getTestSuiteDirectory(normalizedProjectName,
                renameRequest.getOldTestSuiteName());
        boolean renameToResult = testSuiteDirectory.renameTo(getTestSuiteDirectory(normalizedProjectName, renameRequest.getNewTesSuiteName()));
        if (renameToResult) {
            response.setResult("ok");
        } else {
            response.setResult("error");
        }
        return response;
    }

    public File getTestSuiteMainFile(String project, String testSuiteName) {
        File testSuiteDir = getTestSuiteDirectory(project, testSuiteName);
        return new File(testSuiteDir, TEST_SUITE_MAIN_FILE);
    }

    private File getTestSuiteDirectory(String project, String testSuiteName) {
        File testDir = new File(testDirectory);
        File projectDir = new File(testDir, ProjectService.normalizeProjectName(project));
        return new File(projectDir, testSuiteName);
    }

    private String toRelativePath(String path) {
        return path.substring(path.indexOf(testDirectory));
    }

}
