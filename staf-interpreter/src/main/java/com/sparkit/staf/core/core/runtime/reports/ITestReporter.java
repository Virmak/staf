package com.sparkit.staf.core.runtime.reports;

import java.util.List;

public interface ITestReporter {
    void report(String reportsDir, String testSuite, List<TestCaseResult> results);
}
