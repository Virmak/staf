package com.sparkit.staf.core;

import com.sparkit.staf.core.runtime.loader.IStafConfig;
import com.sparkit.staf.core.runtime.loader.IStafFileReader;
import com.sparkit.staf.core.runtime.loader.TestLoader;
import com.sparkit.staf.core.runtime.loader.exceptions.ConfigFileNotFoundException;
import com.sparkit.staf.core.runtime.reports.TestCaseReport;
import org.apache.logging.log4j.LogManager;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class StafTestFacade {
    @Autowired
    private JSONParser parser;
    @Autowired
    private IStafConfig stafConfig;
    @Autowired
    private TestLoader loader;
    @Autowired
    private IStafFileReader stafFileReader;

    public Map<String, List<TestCaseReport>> runTests(String projectDir, String configFile) throws ConfigFileNotFoundException {
        stafConfig.readConfigFile(projectDir, configFile);
        System.setProperty("logFilename", stafConfig.getLogDirectory());
        org.apache.logging.log4j.core.LoggerContext ctx =
                (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
        ctx.reconfigure();
        return loader.runTests();
    }
}
