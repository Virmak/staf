package com.sparkit.staf;

import com.sparkit.staf.runtime.loader.exceptions.ConfigFileNotFoundException;

public class Main {
    public static void main(String[] args) throws ConfigFileNotFoundException {

        String configFile = "config.json";
        if (args.length > 0) {
            configFile = args[0];
        }
        StafTestFacade.runTests(configFile);
    }
}
