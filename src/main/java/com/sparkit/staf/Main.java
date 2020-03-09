package com.sparkit.staf;

import com.sparkit.staf.runtime.interpreter.StafFileReader;
import com.sparkit.staf.runtime.libs.dependencies.DependencyContainer;
import com.sparkit.staf.runtime.loader.IStafConfig;
import com.sparkit.staf.runtime.loader.IStafFileReader;
import com.sparkit.staf.runtime.loader.StafConfig;
import com.sparkit.staf.runtime.loader.TestLoader;
import com.sparkit.staf.runtime.loader.exceptions.ConfigFileNotFoundException;
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
        IStafFileReader stafFileReader = new StafFileReader();
        TestLoader loader = new TestLoader(stafConfig, stafFileReader, container);
        loader.runTests();
    }
}
