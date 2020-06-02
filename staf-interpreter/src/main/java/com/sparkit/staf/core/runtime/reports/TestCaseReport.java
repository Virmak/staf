package com.sparkit.staf.core.runtime.reports;

import com.sparkit.staf.domain.TestResult;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TestCaseReport {
    private String testSuite;
    private String testCase;
    private String errorMessage;
    private TestResult result;
    private List<StatementReport> statementReports;
    private LocalDateTime start;
    private LocalDateTime end;
}
