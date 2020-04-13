package com.sparkit.staf.domain.report;

import com.sparkit.staf.domain.TestResult;
import lombok.Data;

import java.util.Date;

@Data
public class TestCaseReport {
    private int id;
    private String testSuite;
    private String testCase;
    private TestResult result;
    private Date startTime;
    private Date endTime;
}
