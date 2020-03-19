package com.sparkit.staf.runtime.reports;

import java.util.List;

public class JSONReportWriter implements ITestReporter {
    @Override
    public void report(String reportsDir, String testSuite, List<TestCaseResult> results) {
        System.out.println(reportsDir);
    }
}
