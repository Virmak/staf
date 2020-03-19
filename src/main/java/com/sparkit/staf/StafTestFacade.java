package com.sparkit.staf;

import com.sparkit.staf.runtime.config.StafConfig;
import com.sparkit.staf.runtime.interpreter.StafFileReader;
import com.sparkit.staf.runtime.libs.dependencies.DependencyContainer;
import com.sparkit.staf.runtime.loader.IStafConfig;
import com.sparkit.staf.runtime.loader.IStafFileReader;
import com.sparkit.staf.runtime.loader.TestLoader;
import com.sparkit.staf.runtime.loader.exceptions.ConfigFileNotFoundException;
import com.sparkit.staf.runtime.reports.TestCaseReport;
import org.apache.logging.log4j.LogManager;
import org.json.simple.parser.JSONParser;

import java.util.List;

public class StafTestFacade {
    public static List<TestCaseReport> runTests(String configFile) throws ConfigFileNotFoundException {

        DependencyContainer container = new DependencyContainer();
        JSONParser parser = new JSONParser();
        container.register(parser);
        if (configFile == null) {
            configFile = "config.json";
        }

        IStafConfig stafConfig = new StafConfig(parser);
        stafConfig.readConfigFile(configFile);
        if (stafConfig.getLogDirectory() != null) {
            System.setProperty("logFilename", stafConfig.getLogDirectory());
        } else {
            System.setProperty("logFilename", "logs/app.log");
        }
        org.apache.logging.log4j.core.LoggerContext ctx =
                (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
        ctx.reconfigure();
        IStafFileReader stafFileReader = new StafFileReader();
        TestLoader loader = new TestLoader(stafConfig, stafFileReader, container);
        return loader.runTests();
    }
}
