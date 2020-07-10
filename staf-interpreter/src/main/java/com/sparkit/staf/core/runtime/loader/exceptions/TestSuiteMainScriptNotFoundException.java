package com.sparkit.staf.core.runtime.loader.exceptions;

public class TestSuiteMainScriptNotFoundException extends Exception {
    public TestSuiteMainScriptNotFoundException(String testSuite, String fullPath) {
        super("main.staf script for test suite '" + testSuite + "' at : " + fullPath + " not found");
    }
}
