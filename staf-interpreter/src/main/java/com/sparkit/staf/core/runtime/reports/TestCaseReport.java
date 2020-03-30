package com.sparkit.staf.core.runtime.reports;

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
