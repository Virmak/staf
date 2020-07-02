package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.ast.TestCaseDeclaration;
import com.sparkit.staf.core.ast.types.StafInteger;
import com.sparkit.staf.core.runtime.reports.TestCaseReport;
import com.sparkit.staf.core.runtime.reports.TestSuiteReport;
import com.sparkit.staf.domain.ProjectConfig;
import com.sparkit.staf.domain.TestResult;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestSession implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(TestSession.class);
    private static final String SETUP_TEST_CASE = "setup";
    private static final String TEARDOWN_TEST_CASE = "teardown";
    private static final String SESSION_ID_VAR_NAME = "$__session__";
    private static int instanceCount = 0;
    private final StafFile mainStafFile;
    private final TestSuite testSuite;
    private final ProjectConfig projectConfig;
    private final SymbolsTable testSuiteSharedSymbolsTable;
    private final TestCaseExecutor testCaseRunner;
    private final int sessionId;
    @Getter
    private final TestSuiteReport testSuiteReport = new TestSuiteReport();
    private boolean testTerminated = false;

    public TestSession(SymbolsTable testSuiteSharedSymbolsTable, TestCaseExecutor testCaseRunner, StafFile mainStafFile,
                       TestSuite testSuite, ProjectConfig projectConfig) {
        this.testSuiteSharedSymbolsTable = testSuiteSharedSymbolsTable;
        this.testCaseRunner = testCaseRunner;
        this.mainStafFile = mainStafFile;
        this.testSuite = testSuite;
        this.projectConfig = projectConfig;
        this.sessionId = instanceCount++;
    }

    public static void initSessionCount() {
        instanceCount = 0;
    }

    @Override
    public void run() {
        initTestSuiteReport();
        List<TestCaseReport> testCaseReportList = new ArrayList<>();
        SymbolsTable sessionGlobalSymbolsTable = new SymbolsTable(new HashMap<>(testSuiteSharedSymbolsTable.getSymbolsMap()));
        sessionGlobalSymbolsTable.setSymbolValue(SESSION_ID_VAR_NAME, new StafInteger(sessionId));
        TestCaseDeclaration setup = mainStafFile.getTestCaseDeclarationMap().get(SETUP_TEST_CASE);
        TestCaseDeclaration tearDown = mainStafFile.getTestCaseDeclarationMap().get(TEARDOWN_TEST_CASE);
        if (setup != null && isTestCaseEnabled(SETUP_TEST_CASE, testSuite)) {
            TestCaseReport testCaseReport = testCaseRunner.executeTestCase(testSuite, SETUP_TEST_CASE, setup, sessionGlobalSymbolsTable, projectConfig);
            testCaseReportList.add(testCaseReport);
        }
        try {
            for (Map.Entry<String, TestCaseDeclaration> testCaseDeclarationEntry : testSuite.getSortedTestCases()) {
                if (testTerminated) {
                    logger.warn("Test execution terminated by user");
                    testSuiteReport.setMessage("Test execution terminated by user");
                    testSuiteReport.setResult(TestResult.Fail);
                    break;
                }
                if (testCaseDeclarationEntry.getKey().equalsIgnoreCase(SETUP_TEST_CASE)
                        || testCaseDeclarationEntry.getKey().equalsIgnoreCase(TEARDOWN_TEST_CASE)) {
                    continue;
                } else if (testCaseDeclarationEntry.getValue().isIgnored()) {
                    logger.info("Test case [{}] Ignored", testCaseDeclarationEntry.getValue().getName());
                    continue;
                } else if (!isTestCaseEnabled(testCaseDeclarationEntry.getKey(), testSuite)) {
                    continue;
                }
                TestCaseReport testCaseReport = testCaseRunner.executeTestCase(testSuite, testCaseDeclarationEntry.getKey(),
                        testCaseDeclarationEntry.getValue(), sessionGlobalSymbolsTable, projectConfig);
                testCaseReportList.add(testCaseReport);
                if (testCaseReport.getResult() == TestResult.Fail) {
                    testSuiteReport.setResult(TestResult.Fail);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            testSuiteReport.setResult(TestResult.Fail);
        } finally {
            if (tearDown != null && isTestCaseEnabled(TEARDOWN_TEST_CASE, testSuite)) {
                testCaseReportList.add(testCaseRunner.executeTestCase(testSuite, TEARDOWN_TEST_CASE, tearDown, sessionGlobalSymbolsTable, projectConfig));
            }
        }
        testSuiteReport.setTestCaseReports(testCaseReportList);
        testSuiteReport.setEnd(LocalDateTime.now());
    }

    public void stopTestExecution() {
        testTerminated = true;
    }

    private void initTestSuiteReport() {
        testSuiteReport.setStart(LocalDateTime.now());
        testSuiteReport.setTestSuite(testSuite.getTestSuiteName());
        testSuiteReport.setTotal(testSuite.getTestCaseDeclarationMap().size());
        testSuiteReport.setResult(TestResult.Pass);
        testSuiteReport.setTestSessionId(sessionId);
    }

    private boolean isTestCaseEnabled(String testCaseName, TestSuite testSuite) {
        if (testSuite.getSelectedTestCaseMap().containsKey(testCaseName)) {
            return testSuite.getSelectedTestCaseMap().get(testCaseName).isEnabled();
        }
        return false;
    }

}
