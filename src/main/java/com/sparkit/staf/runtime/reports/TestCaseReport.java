package com.sparkit.staf.runtime.reports;

import lombok.Data;

import java.util.Date;

@Data
public class TestCaseReport {
    private String testSuite;
    private String testCase;
    private TestCaseResult result;
    private Date startTime;
    private Date endTime;
}
