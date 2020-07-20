package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.ast.TestCaseDeclaration;
import com.sparkit.staf.core.ast.types.StafInteger;
import com.sparkit.staf.core.runtime.reports.TestCaseReport;
import com.sparkit.staf.core.runtime.reports.TestSuiteReport;
import com.sparkit.staf.core.utils.SharedConstants;
import com.sparkit.staf.domain.ProjectConfig;
import com.sparkit.staf.domain.TestResult;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
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
    private final TestSuite testSuite;
    private final ProjectConfig projectConfig;
    private final MemoryMap testSuiteSharedMemory;
    private final TestCaseExecutor testCaseRunner;
    @Getter
    private final int sessionId;
    @Getter
    private final TestSuiteReport testSuiteReport = new TestSuiteReport();
    private boolean testTerminated = false;

    public TestSession(MemoryMap testSuiteSharedMemory, TestCaseExecutor testCaseRunner, StafFile mainStafFile,
                       TestSuite testSuite, ProjectConfig projectConfig) {
        this.testSuiteSharedMemory = testSuiteSharedMemory;
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
        MemoryMap sessionGlobalMemory = new MemoryMap(new HashMap<>(testSuiteSharedMemory.getVariablesMap()));
        sessionGlobalMemory.setVariableValue(SharedConstants.SESSION_ID_MEMORY_KEY, new StafInteger(sessionId));
        TestCaseDeclaration setup = mainStafFile.getTestCaseDeclarationMap().get(SharedConstants.SETUP_TEST_CASE);
        TestCaseDeclaration tearDown = mainStafFile.getTestCaseDeclarationMap().get(SharedConstants.TEARDOWN_TEST_CASE);
        if (setup != null && isTestCaseEnabled(SharedConstants.SETUP_TEST_CASE, testSuite)) {
            TestCaseReport testCaseReport = testCaseRunner.executeTestCase(testSuite, SharedConstants.SETUP_TEST_CASE, setup, sessionGlobalMemory, projectConfig);
            testCaseReportList.add(testCaseReport);
        }
        try {
            for (Map.Entry<String, TestCaseDeclaration> testCaseDeclarationEntry : testSuite.getSortedTestCases()) {
                if (testTerminated) {
                    logger.warn(SharedConstants.TEST_EXECUTION_TERMINATED_BY_USER);
                    testSuiteReport.setMessage(SharedConstants.TEST_EXECUTION_TERMINATED_BY_USER);
                    testSuiteReport.setResult(TestResult.Fail);
                    if (sessionGlobalMemory.getVariablesMap().containsKey(SharedConstants.WEB_DRIVER_MEMORY_KEY)) {
                        ((WebDriver) sessionGlobalMemory.getVariablesMap().get(SharedConstants.WEB_DRIVER_MEMORY_KEY)).close();
                    }
                    break;
                }
                if (testCaseDeclarationEntry.getKey().equalsIgnoreCase(SharedConstants.SETUP_TEST_CASE)
                        || testCaseDeclarationEntry.getKey().equalsIgnoreCase(SharedConstants.TEARDOWN_TEST_CASE)) {
                    continue;
                } else if (testCaseDeclarationEntry.getValue().isIgnored()) {
                    logger.info(SharedConstants.TEST_CASE_IGNORED, testCaseDeclarationEntry.getValue().getName());
                    continue;
                } else if (!isTestCaseEnabled(testCaseDeclarationEntry.getKey(), testSuite)) {
                    continue;
                }
                TestCaseReport testCaseReport = testCaseRunner.executeTestCase(testSuite, testCaseDeclarationEntry.getKey(),
                        testCaseDeclarationEntry.getValue(), sessionGlobalMemory, projectConfig);
                testCaseReportList.add(testCaseReport);
                if (testCaseReport.getResult() == TestResult.Fail) {
                    testSuiteReport.setResult(TestResult.Fail);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            testSuiteReport.setResult(TestResult.Fail);
        } finally {
            if (tearDown != null && isTestCaseEnabled(SharedConstants.TEARDOWN_TEST_CASE, testSuite)) {
                testCaseReportList.add(testCaseRunner.executeTestCase(testSuite, SharedConstants.TEARDOWN_TEST_CASE, tearDown, sessionGlobalMemory, projectConfig));
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
