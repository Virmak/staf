package com.sparkit.staf.core.runtime.loader;

import com.sparkit.staf.core.Main;
import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.parser.SyntaxErrorException;
import com.sparkit.staf.core.runtime.interpreter.*;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.loader.exceptions.TestSuiteMainScriptNotFoundException;
import com.sparkit.staf.core.runtime.reports.TestCaseReport;
import com.sparkit.staf.core.runtime.reports.TestSuiteReport;
import com.sparkit.staf.core.runtime.reports.TestSuiteResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TestLoader {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private final IStafConfig config;
    private final IStafFileReader stafFileReader;
    @Value("${testDirectory}")
    String testDirectory;
    private Map<String, List<TestCaseReport>> reports = new HashMap<>();
    @Autowired
    private TestContainer testContainer;

    public TestLoader(IStafConfig config, IStafFileReader stafFileReader) {
        this.config = config;
        this.stafFileReader = stafFileReader;
    }

    public List<TestSuiteReport> runTests(List<String> testSuites) {
        List<TestSuiteReport> testSuiteReports = new ArrayList<>();
        for (String testSuite : config.testSuites()) {
            if (!testSuites.contains(testSuite)) {
                continue;
            }
            TestSuiteReport testSuiteReport = new TestSuiteReport();
            testSuiteReport.setTestSuite(testSuite);
            try {
                testSuiteReport.setTestCaseReports(runTestScript(testSuite + "/main.staf", testSuite, testDirectory));
                testSuiteReport.setResult(TestSuiteResult.Ok);
            } catch (TestSuiteMainScriptNotFoundException e) {
                e.printStackTrace();
                testSuiteReport.setResult(TestSuiteResult.Error);
                testSuiteReport.setMessage("Test suite main.staf script not found");
            } catch (SyntaxErrorException e) {
                testSuiteReport.setResult(TestSuiteResult.Error);
                testSuiteReport.setMessage(e.getMessage());
            }
            testSuiteReports.add(testSuiteReport);
        }
        return testSuiteReports;
    }

    public List<TestCaseReport> runTestScript(String mainFilePath, String testSuitePath, String testDirectory)
            throws TestSuiteMainScriptNotFoundException, SyntaxErrorException {
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
        return interpreter.run();
    }

    public Map<String, List<TestCaseReport>> getReports() {
        return reports;
    }
}
