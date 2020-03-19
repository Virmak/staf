package com.sparkit.staf.core.runtime.loader;

import com.sparkit.staf.core.Main;
import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.runtime.interpreter.*;
import com.sparkit.staf.core.runtime.libs.dependencies.DependencyContainer;
import com.sparkit.staf.core.runtime.loader.exceptions.TestSuiteMainScriptNotFoundException;
import com.sparkit.staf.core.runtime.reports.TestCaseReport;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class TestLoader {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private final IStafConfig config;
    private final IStafFileReader stafFileReader;
    private final DependencyContainer dependencyContainer;
    private List<TestCaseReport> reports;

    public TestLoader(IStafConfig config, IStafFileReader stafFileReader, DependencyContainer dependencyContainer) {
        this.config = config;
        this.stafFileReader = stafFileReader;
        this.dependencyContainer = dependencyContainer;
    }

    public List<TestCaseReport> runTests() {
        String testDirectory = config.getTestDirectory();
        for (String testSuite : config.testSuites()) {
            try {
                runTestScript(testSuite + "/main.staf", testSuite, testDirectory);
            } catch (TestSuiteMainScriptNotFoundException e) {
                e.printStackTrace();
            }
        }

        return reports;
    }

    public void runTestScript(String mainFilePath, String testSuitePath, String testDirectory) throws TestSuiteMainScriptNotFoundException {
        logger.info("Running test suite : " + testSuitePath);
        TestSuite testSuite = new TestSuite(testSuitePath, testDirectory);
        dependencyContainer.register(testSuite);
        String fullPath = testDirectory + "/" + mainFilePath;
        StafFile scriptAST;
        try {
            scriptAST = stafFileReader.compile(fullPath);
        } catch (IOException e) {
            throw new TestSuiteMainScriptNotFoundException(testSuitePath);
        }
        SymbolsTable globalSymTable = new SymbolsTable();
        KeywordLibrariesRepository keywordsRepository = new KeywordLibrariesRepository(scriptAST.getKeywordDeclarationMap(),
                globalSymTable, dependencyContainer);
        IStafScriptBuilder scriptBuilder = new StafScriptBuilder(stafFileReader, globalSymTable, keywordsRepository);
        ImportsInterpreter importsInterpreter = new ImportsInterpreter(scriptBuilder, keywordsRepository, testDirectory);

        StafScriptInterpreter interpreter = new StafScriptInterpreter(importsInterpreter, scriptAST, globalSymTable, keywordsRepository,
                testDirectory + "/" + testSuitePath, testSuite.getTestSuiteName());
        reports = interpreter.run();
    }

    public List<TestCaseReport> getReports() {
        return reports;
    }
}
