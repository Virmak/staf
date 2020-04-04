package com.sparkit.staf.core;

import com.sparkit.staf.core.runtime.loader.IStafCompiler;
import com.sparkit.staf.core.runtime.loader.IStafConfig;
import com.sparkit.staf.core.runtime.loader.TestRunner;
import com.sparkit.staf.core.runtime.loader.exceptions.ConfigFileNotFoundException;
import com.sparkit.staf.core.runtime.reports.TestSuiteReport;
import org.apache.logging.log4j.LogManager;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public List<TestSuiteReport> runProject(String testDir, String projectDir, String configFile, List<String> testSuites) throws ConfigFileNotFoundException {
        stafConfig.readConfigFile(projectDir, configFile);
        System.setProperty("logFilename", stafConfig.getLogDirectory() + "/test.log");
        System.setProperty("testDirectory", testDir);
        org.apache.logging.log4j.core.LoggerContext ctx =
                (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
        ctx.reconfigure();
        return loader.runTests(testSuites);
    }
}
