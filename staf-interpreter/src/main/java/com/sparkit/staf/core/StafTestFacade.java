package com.sparkit.staf.core;

import com.sparkit.staf.core.models.RunTestRequest;
import com.sparkit.staf.core.models.RunTestSuite;
import com.sparkit.staf.core.parser.SyntaxErrorException;
import com.sparkit.staf.core.runtime.loader.IStafProjectConfigReader;
import com.sparkit.staf.core.runtime.loader.TestSuiteRunner;
import com.sparkit.staf.core.runtime.loader.exceptions.TestSuiteMainScriptNotFoundException;
import com.sparkit.staf.core.runtime.reports.ITestReportWriter;
import com.sparkit.staf.core.runtime.reports.TestSuiteReport;
import com.sparkit.staf.core.utils.SharedConstants;
import com.sparkit.staf.domain.ProjectConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Component
public class StafTestFacade {
    private static final Logger logger = LogManager.getLogger(StafTestFacade.class);
    @Autowired
    private IStafProjectConfigReader projectConfigReader;
    @Autowired
    private TestSuiteRunner loader;
    @Autowired
    private ITestReportWriter jsonReportWriter;

    public List<TestSuiteReport> runProject(String testDir, String projectDir, String configFile, RunTestRequest runTestRequest) throws IOException {
        ProjectConfig projectConfig = projectConfigReader.readConfigFile(new File(configFile));
        String logFilePath = getLogFilePath(projectConfig.getLogDir());
        System.setProperty(AppConfig.LOGGING_FILE, logFilePath);
        System.setProperty(AppConfig.TEST_DIRECTORY, testDir);
        if (runTestRequest.getWebDriverOptions() != null) {
            setWebDriverSystemProperties(runTestRequest);
        }

        logger.info(SharedConstants.RUNNING_PROJECT, projectDir);

        List<CompletableFuture<List<TestSuiteReport>>> futureList = new ArrayList<>();
        for (RunTestSuite testSuite : runTestRequest.getTestSuites()) {
            futureList.add(getTestSuiteFuture(testSuite, runTestRequest.getWebDriverOptions().getSessionCount(), projectConfig));
        }

        return futureList.stream().map(CompletableFuture::join)
                .flatMap(Collection::stream).collect(Collectors.toList());
    }

    private void setWebDriverSystemProperties(RunTestRequest runTestRequest) {
        System.setProperty(AppConfig.WEB_DRIVER_ADDRESS, runTestRequest.getWebDriverOptions().getWebDriverAddress());
        System.setProperty(AppConfig.REMOTE_WEB_DRIVER, String.valueOf(runTestRequest.getWebDriverOptions().isRemote()));
        System.setProperty(AppConfig.BROWSER_NAME, runTestRequest.getWebDriverOptions().getBrowserName());
        System.setProperty(AppConfig.BROWSER_VERSION, runTestRequest.getWebDriverOptions().getBrowserVersion());
        System.setProperty(AppConfig.ENABLE_VNC, String.valueOf(runTestRequest.getWebDriverOptions().isEnableVnc()));
        System.setProperty(AppConfig.ENABLE_VIDEO, String.valueOf(runTestRequest.getWebDriverOptions().isEnableVideo()));
    }

    private CompletableFuture<List<TestSuiteReport>> getTestSuiteFuture(RunTestSuite runTestSuiteRequest, int sessionCount, ProjectConfig projectConfig) {
        return CompletableFuture.supplyAsync(() -> {
            List<TestSuiteReport> testSuiteReport = null;
            try {
                testSuiteReport = loader.runTests(runTestSuiteRequest, sessionCount, projectConfig);
            } catch (SyntaxErrorException | TestSuiteMainScriptNotFoundException e) {
                e.printStackTrace();
            }
            if (testSuiteReport != null && !testSuiteReport.isEmpty()) {
                jsonReportWriter.write(projectConfig, runTestSuiteRequest.getName(), testSuiteReport);
            }
            return testSuiteReport;
        });
    }

    private String getCurrentDateTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(SharedConstants.YYYY_MM_DD_HH_MM_SS);
        return dateTimeFormatter.format(LocalDateTime.now());
    }

    private String getLogFilePath(String logDirectory) {
        File logFile = new File(logDirectory, getCurrentDateTime() + ".log");
        return logFile.getPath();
    }
}
