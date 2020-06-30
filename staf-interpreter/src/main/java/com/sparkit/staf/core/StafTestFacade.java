package com.sparkit.staf.core;

import com.sparkit.staf.core.parser.SyntaxErrorException;
import com.sparkit.staf.core.runtime.libs.builtin.selenium.WebDriverOptions;
import com.sparkit.staf.core.runtime.loader.IStafConfig;
import com.sparkit.staf.core.runtime.loader.TestSuiteRunner;
import com.sparkit.staf.core.runtime.loader.exceptions.ConfigFileNotFoundException;
import com.sparkit.staf.core.runtime.loader.exceptions.TestSuiteMainScriptNotFoundException;
import com.sparkit.staf.core.runtime.reports.ITestReportWriter;
import com.sparkit.staf.core.runtime.reports.TestSuiteReport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Paths;
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
    private IStafConfig stafConfig;
    @Autowired
    private TestSuiteRunner loader;
    @Autowired
    private ITestReportWriter jsonReportWriter;

    public List<TestSuiteReport> runProject(String testDir, String projectDir, String configFile, List<String> testSuites,
                                            WebDriverOptions webDriverOptions,
                                            int sessionCount)
            throws ConfigFileNotFoundException {
        stafConfig.readConfigFile(projectDir, configFile);
        String logFilePath = getLogFilePath(stafConfig.getLogDirectory());
        System.setProperty("logging.file", logFilePath);
        System.setProperty("testDirectory", testDir);
        if (webDriverOptions != null) {
            System.setProperty("webDriverAddress", webDriverOptions.getWebDriverAddress());
            System.setProperty("remote", String.valueOf(webDriverOptions.isRemote()));
            System.setProperty("browserName", webDriverOptions.getBrowserName());
            System.setProperty("browserVersion", webDriverOptions.getBrowserVersion());
            System.setProperty("enableVnc", String.valueOf(webDriverOptions.isEnableVnc()));
            System.setProperty("enableVideo", String.valueOf(webDriverOptions.isEnableVideo()));
        }

        logger.info("Running project '{}'", projectDir);

        List<CompletableFuture<List<TestSuiteReport>>> futureList = new ArrayList<>();
        for (String testSuite : testSuites) {
            futureList.add(getTestSuiteFuture(testSuite, sessionCount, testDir));
        }

        List<TestSuiteReport> collect = futureList.stream().map(CompletableFuture::join)
                .flatMap(Collection::stream).collect(Collectors.toList());
        return collect;
    }

    private CompletableFuture<List<TestSuiteReport>> getTestSuiteFuture(String testSuite, int sessionCount, String testDir) {
        return CompletableFuture.supplyAsync(() -> {
            List<TestSuiteReport> testSuiteReport = null;
            try {
                testSuiteReport = loader.runTests(testSuite, sessionCount);
            } catch (SyntaxErrorException e) {
                e.printStackTrace();
            } catch (TestSuiteMainScriptNotFoundException e) {
                e.printStackTrace();
            }
            jsonReportWriter.write(Paths.get(testDir).toAbsolutePath() + "/" + stafConfig.getProjectDir()
                    + "/results/" + testSuite + "-" + getCurrentDateTime() + ".json", testSuiteReport);
            return testSuiteReport;
        });
    }

    private String getCurrentDateTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTimeFormatter.format(LocalDateTime.now());
    }

    private String getLogFilePath(String logDirectory) {
        File logFile = new File(logDirectory, getCurrentDateTime() + ".log");
        return logFile.getPath();
    }
}
