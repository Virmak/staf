package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.ast.TestCaseDeclaration;
import com.sparkit.staf.core.runtime.reports.TestCaseReport;
import com.sparkit.staf.core.runtime.reports.TestSuiteReport;
import com.sparkit.staf.domain.TestResult;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestSession implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(TestSession.class);
    private final StafFile mainStafFile;
    private final List<Map.Entry<String, TestCaseDeclaration>> testCasesEntryList;
    private final SymbolsTable sharedGlobalSymbolsTable;
    private final TestcaseExecutor testCaseRunner;
    private boolean testTerminated = false;
    @Getter
    private final TestSuiteReport testSuiteReport = new TestSuiteReport();

    public TestSession(SymbolsTable sharedGlobalSymbolsTable, TestcaseExecutor testCaseRunner, StafFile mainStafFile,
                       List<Map.Entry<String, TestCaseDeclaration>> testCasesEntryList) {
        this.sharedGlobalSymbolsTable = sharedGlobalSymbolsTable;
        this.testCaseRunner = testCaseRunner;
        this.mainStafFile = mainStafFile;
        this.testCasesEntryList = testCasesEntryList;
    }

    @Override
    public void run() {
        initTestSuiteReport();
        List<TestCaseReport> testCaseReportList = new ArrayList<>();
        SymbolsTable globalSymbolsTable = new SymbolsTable(new HashMap<>(sharedGlobalSymbolsTable.getSymbolsMap()));
        TestCaseDeclaration setup = mainStafFile.getTestCaseDeclarationMap().get("setup");
        TestCaseDeclaration tearDown = mainStafFile.getTestCaseDeclarationMap().get("teardown");
        if (setup != null) {
            testCaseReportList.add(testCaseRunner.executeTestCase(mainStafFile.getSuiteName(), "SETUP", setup, globalSymbolsTable));
        }
        try {
            for (Map.Entry<String, TestCaseDeclaration> testCase : testCasesEntryList) {
                if (testTerminated) {
                    logger.warn("Test execution terminated by user");
                    testSuiteReport.setMessage("Test execution terminated by user");
                    testSuiteReport.setResult(TestResult.Fail);
                    break;
                }
                if (testCase.getKey().toLowerCase().equals("setup") || testCase.getKey().toLowerCase().equals("teardown")) {
                    continue;
                } else if (testCase.getValue().isIgnored()) {
                    logger.info("Test case [" + testCase.getValue().getName() + "] Ignored");
                    continue;
                }
                TestCaseReport testCaseReport = testCaseRunner.executeTestCase(mainStafFile.getSuiteName(), testCase.getKey(), testCase.getValue(), globalSymbolsTable);
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
                testCaseReportList.add(testCaseRunner.executeTestCase(mainStafFile.getSuiteName(), "TEARDOWN", tearDown, globalSymbolsTable));
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
        testSuiteReport.setTestSuite(mainStafFile.getSuiteName());
        testSuiteReport.setTotal(testCasesEntryList.size());
        testSuiteReport.setResult(TestResult.Pass);
        testSuiteReport.setTestSessionId(Instant.now().getEpochSecond());
    }

}
