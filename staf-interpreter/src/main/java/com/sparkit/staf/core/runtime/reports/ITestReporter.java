package com.sparkit.staf.core.runtime.reports;

import com.sparkit.staf.domain.TestResult;

import java.util.List;

public interface ITestReporter {
    void report(String reportsDir, String testSuite, List<TestResult> results);
}
