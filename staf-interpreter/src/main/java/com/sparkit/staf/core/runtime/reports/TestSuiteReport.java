package com.sparkit.staf.core.runtime.reports;

import com.sparkit.staf.domain.TestResult;
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
    private int total;
    private int pass;
    private int failed;
}
