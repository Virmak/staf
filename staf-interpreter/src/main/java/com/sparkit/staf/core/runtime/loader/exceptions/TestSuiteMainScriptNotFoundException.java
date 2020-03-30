package com.sparkit.staf.core.runtime.loader.exceptions;

public class TestSuiteMainScriptNotFoundException extends Exception {
    public TestSuiteMainScriptNotFoundException(String testSuite) {
        super("main.staf script for test suite '" + testSuite + "' not found");
    }
}
