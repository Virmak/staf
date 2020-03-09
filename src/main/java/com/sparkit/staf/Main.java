package com.sparkit.staf;

import com.sparkit.staf.runtime.interpreter.StafFileReader;
import com.sparkit.staf.runtime.loader.IStafConfig;
import com.sparkit.staf.runtime.loader.IStafFileReader;
import com.sparkit.staf.runtime.loader.StafConfig;
import com.sparkit.staf.runtime.loader.TestLoader;
import com.sparkit.staf.runtime.loader.exceptions.ConfigFileNotFoundException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ConfigFileNotFoundException {
        String configFile = "config.json";
        if (args.length > 0) {
            configFile = args[0];
        }
        IStafConfig stafConfig = new StafConfig();
        stafConfig.readConfig(configFile);
        IStafFileReader stafFileReader = new StafFileReader();
        TestLoader loader = new TestLoader(stafConfig, stafFileReader);
        loader.runTests();
    }
}
