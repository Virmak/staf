package com.sparkit.staf.core;

import com.sparkit.staf.core.runtime.loader.exceptions.ConfigFileNotFoundException;

public class Main {
    public static void main(String[] args) throws ConfigFileNotFoundException {

        String configFile = "config.json";
        if (args.length > 0) {
            configFile = args[0];
        }
        System.out.println("STAF INTERPRETER STARTED ...");
        //StafTestFacade.runTests(configFile);
    }
}
