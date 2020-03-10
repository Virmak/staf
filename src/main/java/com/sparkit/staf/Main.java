package com.sparkit.staf;

import com.sparkit.staf.runtime.interpreter.StafFileReader;
import com.sparkit.staf.runtime.libs.dependencies.DependencyContainer;
import com.sparkit.staf.runtime.loader.IStafConfig;
import com.sparkit.staf.runtime.loader.IStafFileReader;
import com.sparkit.staf.runtime.config.StafConfig;
import com.sparkit.staf.runtime.loader.TestLoader;
import com.sparkit.staf.runtime.loader.exceptions.ConfigFileNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.json.simple.parser.JSONParser;

public class Main {
    public static void main(String[] args) throws ConfigFileNotFoundException {
        DependencyContainer container = new DependencyContainer();
        JSONParser parser = new JSONParser();
        container.register(parser);
        String configFile = "config.json";
        if (args.length > 0) {
            configFile = args[0];
        }
        IStafConfig stafConfig = new StafConfig(parser);
        stafConfig.readConfig(configFile);
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
        loader.runTests();
    }
}
