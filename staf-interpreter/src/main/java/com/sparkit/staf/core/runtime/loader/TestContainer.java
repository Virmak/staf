package com.sparkit.staf.core.runtime.loader;

import com.sparkit.staf.core.runtime.interpreter.TestSuite;

public class TestContainer { // Used to save current running test suite
    private TestSuite testSuite;

    public TestSuite getTestSuite() {
        return testSuite;
    }

    public void setTestSuite(TestSuite testSuite) {
        this.testSuite = testSuite;
    }
}
