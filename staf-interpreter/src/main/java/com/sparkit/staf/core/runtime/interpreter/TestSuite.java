package com.sparkit.staf.core.runtime.interpreter;

import lombok.Getter;
import lombok.Setter;

public class TestSuite {
    @Getter
    private final String testSuiteName;
    @Getter
    @Setter
    private String testDirectory;

    public TestSuite(String testSuiteName, String testDirectory) {
        this.testSuiteName = testSuiteName;
        this.testDirectory = testDirectory;
    }

    public String getFullPath() {
        return testDirectory + "/" + testSuiteName;
    }
}
