package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.TestCaseDeclaration;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.KeywordCall;
import com.sparkit.staf.core.ast.types.StafString;
import com.sparkit.staf.core.runtime.interpreter.exceptions.FatalErrorException;
import com.sparkit.staf.core.runtime.loader.IStafConfig;
import com.sparkit.staf.core.runtime.reports.StatementReport;
import com.sparkit.staf.core.runtime.reports.TestCaseReport;
import com.sparkit.staf.domain.TestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.EmptyStackException;

@Component
public class TestCaseExecutor {
    private static final Logger logger = LoggerFactory.getLogger(TestCaseExecutor.class);
    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;
    @Autowired
    private StatementBlockExecutor statementBlockExecutor;
    @Autowired
    private IStafConfig config;

    @Value("#{systemProperties['testDirectory']}")
    private String testDirectory;


    public TestCaseReport executeTestCase(TestSuite testSuite, String testCaseName, TestCaseDeclaration testCaseDeclaration,
                                          SymbolsTable globalSymTable) {
        TestCaseReport testCaseReport = new TestCaseReport();
        testCaseReport.setTestSuite(testSuite.getTestSuiteName());
        testCaseReport.setTestCase(testCaseName);
        testCaseReport.setStart(LocalDateTime.now());
        testCaseReport.setResult(TestResult.Pass);
        testCaseReport.setStatementReports(new ArrayList<>());
        String lastErrorMessage = null;
        logger.info("Started executing test case : [{}]", testCaseDeclaration.getName());
        OnStatementFailed statementFailed = statementReport -> {
            testCaseReport.setResult(TestResult.Fail);
            if (!testSuite.getKeywordLibrariesRepository().isKeywordDeclared("capturescreenshot")) {
                return;
            }
            StafString screenShotPath = new StafString(testDirectory + "/" + config.getProjectDir() + "/"
                    + testSuite + "/" + config.getReportingDirectory()
                    + "/screenshot-" + testSuite + "-" + testCaseName.replaceAll("\\s*", "")
                    + "-" + new Date().getTime() + ".png");
            try {
                KeywordCall captureScreenshotKeyword = new KeywordCall(statementBlockExecutor,
                        "capturescreenshot", Arrays.asList(new AbstractStafObject[]{screenShotPath}));
                captureScreenshotKeyword.execute(globalSymTable, null, testSuite.getKeywordLibrariesRepository());
            } catch (EmptyStackException e) {
                logger.error("No browser open");
                statementReport.setErrorMessage("No browser open");
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            statementReport.setScreenShot(screenShotPath.getValue().toString());
        };
        statementBlockExecutor.setStatementFailed(statementFailed);
        try {
            SymbolsTable localSymTable = new SymbolsTable();
            autowireCapableBeanFactory.autowireBean(localSymTable);
            testCaseReport.setStatementReports(
                    statementBlockExecutor.execute(testCaseDeclaration, statementFailed, globalSymTable,
                            localSymTable, testSuite.getKeywordLibrariesRepository()));
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
}
