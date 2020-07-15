package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.TestCaseDeclaration;
import com.sparkit.staf.core.runtime.interpreter.exceptions.FatalErrorException;
import com.sparkit.staf.core.runtime.reports.StatementReport;
import com.sparkit.staf.core.runtime.reports.TestCaseReport;
import com.sparkit.staf.domain.ProjectConfig;
import com.sparkit.staf.domain.TestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
public class TestCaseExecutor {
    private static final Logger logger = LoggerFactory.getLogger(TestCaseExecutor.class);
    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;
    @Autowired
    private StatementBlockExecutor statementBlockExecutor;

    @Value("${testDirectory}")
    private String testDirectory;


    public TestCaseReport executeTestCase(TestSuite testSuite, String testCaseName, TestCaseDeclaration testCaseDeclaration,
                                          MemoryMap globalSymTable, ProjectConfig projectConfig) {
        TestCaseReport testCaseReport = createTestCaseReport(testSuite.getTestSuiteName(), testCaseName);
        String lastErrorMessage = null;
        logger.info("Started executing test case : [{}]", testCaseDeclaration.getName());
        OnStatementFailed statementFailed = takeScreenshot(testCaseReport, testSuite, globalSymTable, projectConfig, testCaseName);
        statementBlockExecutor.setStatementFailed(statementFailed);
        try {
            MemoryMap localMemory = new MemoryMap();
            autowireCapableBeanFactory.autowireBean(localMemory);
            testCaseReport.setStatementReports(
                    statementBlockExecutor.execute(testCaseDeclaration, statementFailed, globalSymTable,
                            localMemory, testSuite.getKeywordLibrariesRepository()));
            if (!testCasePass(testCaseReport)) {
                testCaseReport.setResult(TestResult.Fail);
            }
        } catch (Throwable e) {
            if (e instanceof FatalErrorException) {
                testCaseReport.setStatementReports(((FatalErrorException) e).getReports());
            }
            testCaseReport.setResult(TestResult.Fail);
            lastErrorMessage = e.getMessage();
            logger.error("Executing statement failed at [{}] : {} | {}", testSuite, testCaseDeclaration.getName(), e.getMessage());
            e.printStackTrace();
        }
        testCaseReport.setEnd(LocalDateTime.now());
        testCaseReport.setErrorMessage(lastErrorMessage);

        logger.info("Finished executing test case : [{}] {} ", testCaseDeclaration.getName(), testCaseReport.getResult());
        return testCaseReport;
    }

    private boolean testCasePass(TestCaseReport testCaseReport) {
        for (StatementReport statementReport : testCaseReport.getStatementReports()) {
            if (statementReport.getResult() == TestResult.Fail) {
                return false;
            }
        }
        return true;
    }

    private TestCaseReport createTestCaseReport(String testSuiteName, String testCaseName) {
        TestCaseReport testCaseReport = new TestCaseReport();
        testCaseReport.setTestSuite(testSuiteName);
        testCaseReport.setTestCase(testCaseName);
        testCaseReport.setStart(LocalDateTime.now());
        testCaseReport.setResult(TestResult.Pass);
        testCaseReport.setStatementReports(new ArrayList<>());
        return testCaseReport;
    }

    @Bean()
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public OnStatementFailed takeScreenshot(TestCaseReport testCaseReport, TestSuite testSuite, MemoryMap sessionSymbolsTable,
                                            ProjectConfig projectConfig, String testCaseName) {
        return new StatementFailedScreenshot(testCaseReport, testSuite, projectConfig, statementBlockExecutor, sessionSymbolsTable, testDirectory, testCaseName);
    }
}
