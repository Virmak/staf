package com.sparkit.staf.core.runtime.loader;

import com.sparkit.staf.core.Main;
import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.runtime.interpreter.*;
<<<<<<< HEAD:staf-interpreter/src/main/java/com/sparkit/staf/core/core/runtime/loader/TestLoader.java
import com.sparkit.staf.core.runtime.libs.dependencies.DependencyContainer;
import com.sparkit.staf.core.runtime.loader.exceptions.TestSuiteMainScriptNotFoundException;
import com.sparkit.staf.core.runtime.reports.TestCaseReport;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
=======
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.loader.exceptions.TestSuiteMainScriptNotFoundException;
import com.sparkit.staf.core.runtime.reports.TestCaseReport;
>>>>>>> 7a82d8117d101f54165fa8a08889696c97e79217:staf-interpreter/src/main/java/com/sparkit/staf/core/runtime/loader/TestLoader.java
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TestLoader {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private final IStafConfig config;
    private final IStafFileReader stafFileReader;
    private Map<String, List<TestCaseReport>> reports = new HashMap<>();
    @Autowired
    private TestContainer testContainer;
    @Value("${testDirectory}")
    String testDirectory;

    public TestLoader(IStafConfig config, IStafFileReader stafFileReader) {
        this.config = config;
        this.stafFileReader = stafFileReader;
    }

    public void setTestContainer(TestContainer testContainer) {
        this.testContainer = testContainer;
    }

    public Map<String, List<TestCaseReport>> runTests() {
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
        testContainer.setTestSuite(testSuite);
        String fullPath = testDirectory + "/" + config.getProjectDir() + "/" + mainFilePath;
        StafFile scriptAST;
        try {
            scriptAST = stafFileReader.compile(fullPath);
        } catch (IOException e) {
            throw new TestSuiteMainScriptNotFoundException(testSuitePath);
        }
        SymbolsTable globalSymTable = new SymbolsTable();
        KeywordLibrariesRepository keywordsRepository = new KeywordLibrariesRepository(scriptAST.getKeywordDeclarationMap(),
                globalSymTable, testContainer);
        IStafScriptBuilder scriptBuilder = new StafScriptBuilder(stafFileReader, globalSymTable, keywordsRepository);
        ImportsInterpreter importsInterpreter = new ImportsInterpreter(scriptBuilder, keywordsRepository, testDirectory);

        StafScriptInterpreter interpreter = new StafScriptInterpreter(importsInterpreter, scriptAST, globalSymTable, keywordsRepository,
                testDirectory + "/" + config.getProjectDir() + "/" + testSuitePath, testSuite.getTestSuiteName());
        reports.put(testSuite.getTestSuiteName(), interpreter.run());
    }

    public Map<String, List<TestCaseReport>> getReports() {
        return reports;
    }
}
