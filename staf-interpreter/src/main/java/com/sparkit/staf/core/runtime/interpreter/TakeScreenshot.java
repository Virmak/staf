package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.KeywordCall;
import com.sparkit.staf.core.ast.types.StafString;
import com.sparkit.staf.core.runtime.loader.IStafConfig;
import com.sparkit.staf.core.runtime.reports.StatementReport;
import com.sparkit.staf.core.runtime.reports.TestCaseReport;
import com.sparkit.staf.domain.TestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Date;
import java.util.EmptyStackException;

public class TakeScreenshot implements OnStatementFailed {
    private static final Logger logger = LoggerFactory.getLogger(TakeScreenshot.class);
    private static final String CAPTURE_SCREENSHOT_KEYWORD_NAME = "capturescreenshot";
    private TestCaseReport testCaseReport;
    private TestSuite testSuite;
    private IStafConfig config;
    private StatementBlockExecutor statementBlockExecutor;
    private SymbolsTable sessionGlobalSymbolsTable;
    private String testDirectory;

    public TakeScreenshot(TestCaseReport testCaseReport, TestSuite testSuite, IStafConfig config, StatementBlockExecutor statementBlockExecutor, SymbolsTable sessionGlobalSymbolsTable, String testDirectory, String testCaseName) {
        this.testCaseReport = testCaseReport;
        this.testSuite = testSuite;
        this.config = config;
        this.statementBlockExecutor = statementBlockExecutor;
        this.sessionGlobalSymbolsTable = sessionGlobalSymbolsTable;
        this.testDirectory = testDirectory;
        this.testCaseName = testCaseName;
    }

    private String testCaseName;


    @Override
    public void execute(StatementReport statementReport) {
        testCaseReport.setResult(TestResult.Fail);
        if (!testSuite.getKeywordLibrariesRepository().isKeywordDeclared(CAPTURE_SCREENSHOT_KEYWORD_NAME)) {
            return;
        }
        StafString screenShotPath = new StafString(testDirectory + "/" + config.getProjectDir() + "/"
                + testSuite + "/" + config.getReportingDirectory()
                + "/screenshot-" + testSuite + "-" + testCaseName.replaceAll("\\s*", "")
                + "-" + new Date().getTime() + ".png");
        try {
            KeywordCall captureScreenshotKeyword = new KeywordCall(statementBlockExecutor,
                    CAPTURE_SCREENSHOT_KEYWORD_NAME, Arrays.asList(new AbstractStafObject[]{screenShotPath}));
            captureScreenshotKeyword.execute(sessionGlobalSymbolsTable, null, testSuite.getKeywordLibrariesRepository());
        } catch (EmptyStackException e) {
            logger.error("No browser open");
            statementReport.setErrorMessage("No browser open");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        statementReport.setScreenShot(screenShotPath.getValue().toString());
    }
}
