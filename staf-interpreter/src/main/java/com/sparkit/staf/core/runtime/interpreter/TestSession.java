package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.ast.TestCaseDeclaration;
import com.sparkit.staf.core.ast.types.StafInteger;
import com.sparkit.staf.core.runtime.reports.TestCaseReport;
import com.sparkit.staf.core.runtime.reports.TestSuiteReport;
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
    private static int instanceCount = 0;
    private final StafFile mainStafFile;
    private final List<Map.Entry<String, TestCaseDeclaration>> testCasesEntryList;
    private final String testSuite;
    private final SymbolsTable sharedGlobalSymbolsTable;
    private final TestCaseExecutor testCaseRunner;
    private final int sessionId;
    @Getter
    private final TestSuiteReport testSuiteReport = new TestSuiteReport();
    private boolean testTerminated = false;

    public TestSession(SymbolsTable sharedGlobalSymbolsTable, TestCaseExecutor testCaseRunner, StafFile mainStafFile,
                       List<Map.Entry<String, TestCaseDeclaration>> testCasesEntryList, String testSuite) {
        this.sharedGlobalSymbolsTable = sharedGlobalSymbolsTable;
        this.testCaseRunner = testCaseRunner;
        this.mainStafFile = mainStafFile;
        this.testCasesEntryList = testCasesEntryList;
        this.testSuite = testSuite;
        this.sessionId = instanceCount++;
    }

    public static void initSessionCount() {
        instanceCount = 0;
    }

    @Override
    public void run() {
        initTestSuiteReport();
        List<TestCaseReport> testCaseReportList = new ArrayList<>();
        SymbolsTable sessionGlobalSymbolsTable = new SymbolsTable(new HashMap<>(sharedGlobalSymbolsTable.getSymbolsMap()));
        sessionGlobalSymbolsTable.setSymbolValue("$__session__", new StafInteger(sessionId));
        TestCaseDeclaration setup = mainStafFile.getTestCaseDeclarationMap().get("setup");
        TestCaseDeclaration tearDown = mainStafFile.getTestCaseDeclarationMap().get("teardown");
        if (setup != null) {
            testCaseReportList.add(testCaseRunner.executeTestCase(testSuite, "SETUP", setup, sessionGlobalSymbolsTable));
        }
        try {
            for (Map.Entry<String, TestCaseDeclaration> testCase : testCasesEntryList) {
                if (testTerminated) {
                    logger.warn("Test execution terminated by user");
                    testSuiteReport.setMessage("Test execution terminated by user");
                    testSuiteReport.setResult(TestResult.Fail);
                    break;
                }
                if (testCase.getKey().equalsIgnoreCase("setup") || testCase.getKey().equalsIgnoreCase("teardown")) {
                    continue;
                } else if (testCase.getValue().isIgnored()) {
                    logger.info("Test case [{}] Ignored", testCase.getValue().getName());
                    continue;
                }
                TestCaseReport testCaseReport = testCaseRunner.executeTestCase(testSuite, testCase.getKey(), testCase.getValue(), sessionGlobalSymbolsTable);
                testCaseReportList.add(testCaseReport);
                if (testCaseReport.getResult() == TestResult.Fail) {
                    testSuiteReport.setResult(TestResult.Fail);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            testSuiteReport.setResult(TestResult.Fail);
        } finally {
            if (tearDown != null) {
                testCaseReportList.add(testCaseRunner.executeTestCase(testSuite, "TEARDOWN", tearDown, sessionGlobalSymbolsTable));
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
        testSuiteReport.setTestSuite(testSuite);
        testSuiteReport.setTotal(testCasesEntryList.size());
        testSuiteReport.setResult(TestResult.Pass);
        testSuiteReport.setTestSessionId(sessionId);
    }

}
