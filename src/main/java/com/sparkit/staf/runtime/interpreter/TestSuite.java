package com.sparkit.staf.runtime.interpreter;

public class TestSuite {
    private String testSuiteName;
    private String testDirectory;

    public TestSuite(String testSuiteName, String testDirectory) {
        this.testSuiteName = testSuiteName;
        this.testDirectory = testDirectory;
    }

    public String getFullPath() {
        return testDirectory + "/" + testSuiteName;
    }

    public String getTestDirectory() {
        return testDirectory;
    }

    public void setTestDirectory(String testDirectory) {
        this.testDirectory = testDirectory;
    }

    public String getTestSuiteName() {
        return testSuiteName;
    }

    public void setTestSuiteName(String testSuiteName) {
        this.testSuiteName = testSuiteName;
    }
}
