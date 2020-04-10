package com.sparkit.staf.core.runtime.reports;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TestSuiteReport {
    private String testSuite;
    private String message;
    private TestResult result;
    private String source;
    private Date start;
    private Date end;
    private List<TestCaseReport> testCaseReports;
}