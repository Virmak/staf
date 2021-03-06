package com.sparkit.staf.core.compiler;

import com.sparkit.staf.core.ast.ImportStatement;
import com.sparkit.staf.core.ast.ImportTypes;
import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.runtime.interpreter.SemanticError;
import com.sparkit.staf.core.utils.SharedConstants;
import com.sparkit.staf.core.validator.SemanticAnalyzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class TestSuiteCompiler {
    private final IStafCompiler stafFileCompiler;
    private final SemanticAnalyzer semanticAnalyzer;
    @Value(SharedConstants.TEST_DIRECTORY_PROPERTY_VALUE)
    private String testDirectory;

    @Autowired
    public TestSuiteCompiler(IStafCompiler stafCompiler, SemanticAnalyzer semanticAnalyzer) {
        this.stafFileCompiler = stafCompiler;
        this.semanticAnalyzer = semanticAnalyzer;
    }

    public Map<String, StafFile> compileTestSuiteWithErrors(String project, String testSuiteName) throws IOException,
            IllegalAccessException, InstantiationException, InvocationTargetException {
        String testSuiteMainFile = getTestSuiteMainFile(project, testSuiteName).getAbsolutePath();
        return compileFile(testSuiteMainFile);
    }

    public Map<String, StafFile> compileFile(String filePath) throws IOException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        StafFile mainScriptAST = stafFileCompiler.compileWithErrors(filePath);
        Map<String, StafFile> testSuiteFilesAST = new HashMap<>();
        testSuiteFilesAST.put(toRelativePath(filePath), mainScriptAST);
        String currentDirectoryPath = mainScriptAST.getFilePath().substring(0, mainScriptAST.getFilePath().lastIndexOf('/'));
        if (mainScriptAST.getImports() != null) {
            loadImports(currentDirectoryPath, mainScriptAST, testSuiteFilesAST);
        }
        semanticAnalyzer.validateSemantics(mainScriptAST, testSuiteFilesAST);
        return testSuiteFilesAST;
    }

    public Map<String, StafFile> compileTestSuite(String project, String testSuiteName) throws IOException {
        String testSuiteMainFilePath = getTestSuiteMainFile(project, testSuiteName).getAbsolutePath();
        StafFile mainScriptAST = stafFileCompiler.compileWithErrors(testSuiteMainFilePath);
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
                    scriptAST = stafFileCompiler.compileWithErrors(importedFileAbsolutePath);
                    testSuiteFilesAST.put(toRelativePath(importedFileAbsolutePath), scriptAST);
                    if (scriptAST.getImports() != null) {
                        loadImports(importedFile.getParentFile().getAbsolutePath(), scriptAST, testSuiteFilesAST);
                    }
                } catch (NoSuchFileException e) {
                    if (parentFileAST.getSemanticErrors() == null) {
                        parentFileAST.setSemanticErrors(new ArrayList<>());
                    }
                    parentFileAST.getSemanticErrors().add(new SemanticError(statement.getTokenPosition(), SharedConstants.INVALID_IMPORT_PATH));
                }
            }
        }
    }

    public File getTestSuiteMainFile(String project, String testSuiteName) {
        File testSuiteDir = getTestSuiteDirectory(project, testSuiteName);
        return new File(testSuiteDir, SharedConstants.TEST_SUITE_MAIN_FILE);
    }


    public File getTestSuiteDirectory(String projectLocation, String testSuiteName) {
        File testDir = new File(testDirectory);
        File projectDir = new File(testDir, projectLocation);
        return new File(projectDir, testSuiteName);
    }

    private String toRelativePath(String path) {
        return path.substring(path.indexOf(testDirectory));
    }
}
