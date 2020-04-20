package com.sparkit.staf.core;

import com.sparkit.staf.core.runtime.loader.IStafCompiler;
import com.sparkit.staf.core.runtime.loader.IStafConfig;
import com.sparkit.staf.core.runtime.loader.TestRunner;
import com.sparkit.staf.core.runtime.loader.exceptions.ConfigFileNotFoundException;
import com.sparkit.staf.core.runtime.reports.ITestReportWriter;
import com.sparkit.staf.core.runtime.reports.TestSuiteReport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class StafTestFacade {
    @Autowired
    private JSONParser parser;
    @Autowired
    private IStafConfig stafConfig;
    @Autowired
    private TestRunner loader;
    @Autowired
    private IStafCompiler stafFileReader;
    @Autowired
    private ITestReportWriter jsonReportWriter;

    private static Logger logger = LogManager.getLogger();

    public List<TestSuiteReport> runProject(String testDir, String projectDir, String configFile, List<String> testSuites) throws ConfigFileNotFoundException {
        stafConfig.readConfigFile(projectDir, configFile);
        System.setProperty("logFilename", stafConfig.getLogDirectory() + getCurrentDateTime() + ".log");
        System.setProperty("testDirectory", testDir);
        List<TestSuiteReport> reports = loader.runTests(testSuites);
        jsonReportWriter.write(stafConfig.getReportingDirectory() + "/reports-" + getCurrentDateTime() + ".json", reports);
        return reports;
    }

    private String getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy-HH:mm:ss");
        return dateFormat.format(new Date()) + ".log";
    }
}
