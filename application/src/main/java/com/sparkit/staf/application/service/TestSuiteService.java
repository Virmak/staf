package com.sparkit.staf.application.service;

import com.sparkit.staf.application.models.response.GetTestSuiteDetailsResponse;
import com.sparkit.staf.core.ast.ImportStatement;
import com.sparkit.staf.core.ast.ImportTypes;
import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.parser.SyntaxErrorException;
import com.sparkit.staf.core.runtime.loader.IStafCompiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
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
        String testSuiteDirectory = getTestSuiteDirectory(project, testSuiteName).getParentFile().getAbsolutePath();
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

    public Map<String, StafFile> compileTestSuite(String project, String testSuiteName) throws IOException, SyntaxErrorException {
        String testSuiteMainFilePath = getTestSuiteDirectory(project, testSuiteName).getAbsolutePath();
        StafFile mainScriptAST = stafCompiler.compile(testSuiteMainFilePath);
        Map<String, StafFile> testSuiteImportedFilesAST = new HashMap<>();
        testSuiteImportedFilesAST.put(testSuiteMainFilePath, mainScriptAST);
        String currentDirectoryPath = mainScriptAST.getFilePath().substring(0, mainScriptAST.getFilePath().lastIndexOf('/'));
        loadImports(currentDirectoryPath, mainScriptAST.getImports(), testSuiteImportedFilesAST);
        return testSuiteImportedFilesAST;
    }

    public void loadImports(String currentDirectory, List<ImportStatement> importStatements, Map<String, StafFile> testSuiteFilesAST)
            throws IOException, SyntaxErrorException {
        for (ImportStatement statement : importStatements) {
            if (statement.getType() == ImportTypes.BUILT_IN_LIBRARY) {
                continue;
            }
            File directory = new File(currentDirectory);
            File importedFile = new File(directory, statement.getPath().replaceAll("[\"']", ""));
            String importedFileAbsolutePath = importedFile.getCanonicalPath();
            if (!testSuiteFilesAST.containsKey(importedFileAbsolutePath)) {
                StafFile scriptAST = stafCompiler.compile(importedFileAbsolutePath);
                testSuiteFilesAST.put(importedFileAbsolutePath, scriptAST);
                if (scriptAST.getImports() != null) {
                    loadImports(importedFile.getParentFile().getAbsolutePath(), scriptAST.getImports(), testSuiteFilesAST);
                }
            }

        }
    }

    private File getTestSuiteDirectory(String project, String testSuiteName) {
        File testDir = new File(testDirectory);
        File projectDir = new File(testDir, ProjectService.normalizeProjectName(project));
        File testSuiteDir = new File(projectDir, testSuiteName);
        return new File(testSuiteDir, TEST_SUITE_MAIN_FILE);
    }

}
