package com.sparkit.staf.core.runtime.reports;

import com.sparkit.staf.domain.TestResult;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TestSuiteReport {
    private String testSuite;
    private String message;
    private TestResult result;
    private String source;
    private String path;
    private LocalDateTime start;
    private LocalDateTime end;
    private List<TestCaseReport> testCaseReports;
    private int total;
    private int pass;
    private int failed;
}
