package com.sparkit.staf.api.exception;

public class TestDirectoryNotFound extends Exception {
    public TestDirectoryNotFound(String testDir) {
        super(testDir);
    }
}
