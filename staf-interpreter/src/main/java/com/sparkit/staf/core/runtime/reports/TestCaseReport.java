package com.sparkit.staf.core.runtime.reports;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TestCaseReport {
    private String testSuite;
    private String testCase;
    private String errorMessage;
    private TestCaseResult result;
    private List<StatementReport> statementReports;
    private Date startTime;
    private Date endTime;
}
