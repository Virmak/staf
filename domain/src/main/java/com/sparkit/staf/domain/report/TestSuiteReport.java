package com.sparkit.staf.domain.report;

import com.sparkit.staf.domain.TestSuite;
import lombok.Data;

import java.util.List;

@Data
public class TestSuiteReport {
    private int id;
    private TestSuite testSuite;
    private List<TestCaseReport> testCases;
}
