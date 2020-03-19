package com.sparkit.staf.runtime.reports;

import java.util.List;

public interface ITestReporter {
    void report(String reportsDir, String testSuite, List<TestCaseResult> results);
}
