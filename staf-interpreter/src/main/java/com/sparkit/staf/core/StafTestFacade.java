package com.sparkit.staf.core;

import com.sparkit.staf.core.parser.SyntaxErrorException;
import com.sparkit.staf.core.runtime.loader.IStafCompiler;
import com.sparkit.staf.core.runtime.loader.IStafConfig;
import com.sparkit.staf.core.runtime.loader.TestSuiteRunner;
import com.sparkit.staf.core.runtime.loader.exceptions.ConfigFileNotFoundException;
import com.sparkit.staf.core.runtime.loader.exceptions.TestSuiteMainScriptNotFoundException;
import com.sparkit.staf.core.runtime.reports.ITestReportWriter;
import com.sparkit.staf.core.runtime.reports.TestSuiteReport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class StafTestFacade {
    private static Logger logger = LogManager.getLogger(Main.class);
    @Autowired
    private IStafConfig stafConfig;
    @Autowired
    private TestSuiteRunner loader;
    @Autowired
    private ITestReportWriter jsonReportWriter;

    public List<TestSuiteReport> runProject(String testDir, String projectDir, String configFile, String testSuite, String webDriverAddress,
                                            int sessionCount)
            throws ConfigFileNotFoundException, TestSuiteMainScriptNotFoundException, SyntaxErrorException {
        stafConfig.readConfigFile(projectDir, configFile);
        String logFilePath = stafConfig.getLogDirectory() + "/" + getCurrentDateTime() + ".log";
        System.setProperty("logging.file", logFilePath);
        System.setProperty("testDirectory", testDir);
        if (webDriverAddress != null) {
            System.setProperty("webDriver", webDriverAddress);
        }

        logger.info("Running project '" + projectDir + "' ");

        List<TestSuiteReport> testSuiteReport = loader.runTests(testSuite, sessionCount);
        jsonReportWriter.write(Paths.get(testDir).toAbsolutePath() + "/" + stafConfig.getProjectDir()
                + "/results/reports-" + getCurrentDateTime() + ".json", testSuiteReport);
        return testSuiteReport;
    }

    private String getCurrentDateTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTimeFormatter.format(LocalDateTime.now());
    }
}
