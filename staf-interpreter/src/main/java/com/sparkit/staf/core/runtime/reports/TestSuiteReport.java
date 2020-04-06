package com.sparkit.staf.core.runtime.reports;

import lombok.Data;

import java.util.List;

@Data
public class TestSuiteReport {
    private String testSuite;
    private String message;
    private TestResult result;
    private List<TestCaseReport> testCaseReports;
}
