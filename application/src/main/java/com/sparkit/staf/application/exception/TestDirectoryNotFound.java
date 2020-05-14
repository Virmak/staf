package com.sparkit.staf.application.exception;

public class TestDirectoryNotFound extends Exception {
    public TestDirectoryNotFound(String testDir) {
        super(testDir);
    }
}
