package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.KeywordCall;
import com.sparkit.staf.core.ast.types.StafString;
import com.sparkit.staf.core.runtime.libs.builtin.selenium.SeleniumLibrary;
import com.sparkit.staf.core.runtime.reports.StatementReport;
import com.sparkit.staf.core.runtime.reports.TestCaseReport;
import com.sparkit.staf.domain.ProjectConfig;
import com.sparkit.staf.domain.TestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Date;
import java.util.EmptyStackException;

public class StatementFailedScreenshot implements OnStatementFailed {
    private static final Logger logger = LoggerFactory.getLogger(StatementFailedScreenshot.class);
    private static final String CAPTURE_SCREENSHOT_KEYWORD_NAME = "capturescreenshot";
    private final TestCaseReport testCaseReport;
    private final TestSuite testSuite;
    private final ProjectConfig config;
    private final StatementBlockExecutor statementBlockExecutor;
    private final SymbolsTable sessionGlobalSymbolsTable;
    private final String testDirectory;
    private final String testCaseName;

    public StatementFailedScreenshot(TestCaseReport testCaseReport, TestSuite testSuite, ProjectConfig config,
                                     StatementBlockExecutor statementBlockExecutor, SymbolsTable sessionGlobalSymbolsTable,
                                     String testDirectory, String testCaseName) {
        this.testCaseReport = testCaseReport;
        this.testSuite = testSuite;
        this.config = config;
        this.statementBlockExecutor = statementBlockExecutor;
        this.sessionGlobalSymbolsTable = sessionGlobalSymbolsTable;
        this.testDirectory = testDirectory;
        this.testCaseName = testCaseName;
    }

    @Override
    public void execute(StatementReport statementReport) {
        testCaseReport.setResult(TestResult.Fail);
        if (!testSuite.getKeywordLibrariesRepository().hasLibrary(SeleniumLibrary.class) || !testSuite.getKeywordLibrariesRepository().isKeywordDeclared(CAPTURE_SCREENSHOT_KEYWORD_NAME)) {
            return;
        }
        StafString screenShotPath = new StafString(getScreenshotPath());
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

    private String getScreenshotPath() {
        return testDirectory + "/" + config.getRootPath()
                + "/" + testSuite + "/" + config.getReportsDir()
                + "/screenshot-" + testSuite.getTestSuiteName()
                + "-" + testCaseName.replaceAll("\\s*", "")
                + "-" + new Date().getTime() + ".png";
    }
}
