package com.sparkit.staf.core.runtime.loader;

import com.sparkit.staf.core.Main;
import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.parser.SyntaxErrorException;
import com.sparkit.staf.core.runtime.interpreter.IStafScriptInterpreter;
import com.sparkit.staf.core.runtime.interpreter.TestSuite;
import com.sparkit.staf.core.runtime.loader.exceptions.TestSuiteMainScriptNotFoundException;
import com.sparkit.staf.core.runtime.reports.TestCaseReport;
import com.sparkit.staf.core.runtime.reports.TestSuiteReport;
import com.sparkit.staf.domain.TestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TestRunner {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    @Autowired
    private IStafConfig config;
    @Autowired
    private IStafCompiler stafCompiler;
    @Autowired
    private TestContainer testContainer;
    @Autowired
    private IStafScriptInterpreter interpreter;
    @Value("${testDirectory}")
    private String testDirectory;

    public List<TestSuiteReport> runTests(List<String> testSuites) {
        List<TestSuiteReport> testSuiteReports = new ArrayList<>();
        for (String testSuite : config.testSuites()) {
            if (!testSuites.contains(testSuite)) {
                continue;
            }
            TestSuiteReport testSuiteReport = new TestSuiteReport();
            testSuiteReport.setStart(new Date());
            testSuiteReport.setTestSuite(testSuite);
            testSuiteReport.setSource(testSuite + "/main.staf");
            try {
                testSuiteReport.setTestCaseReports(runTestScript(testSuite + "/main.staf", testSuite, testDirectory));
                testSuiteReport.setResult(TestResult.Pass);
            } catch (TestSuiteMainScriptNotFoundException e) {
                e.printStackTrace();
                testSuiteReport.setResult(TestResult.Fail);
                testSuiteReport.setMessage("Test suite main.staf script not found");
            } catch (SyntaxErrorException e) {
                testSuiteReport.setResult(TestResult.Fail);
                testSuiteReport.setMessage(e.getMessage());
            }
            testSuiteReport.setEnd(new Date());
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
            scriptAST = stafCompiler.compile(fullPath);
        } catch (IOException e) {
            throw new TestSuiteMainScriptNotFoundException(testSuitePath);
        }
        return interpreter.run(System.getProperty("user.dir"), testSuite.getTestSuiteName(), scriptAST);
    }
}
