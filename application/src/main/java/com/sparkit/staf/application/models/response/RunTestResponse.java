package com.sparkit.staf.application.models.response;

import com.sparkit.staf.core.runtime.reports.TestSuiteReport;
import lombok.Data;

import java.util.List;

@Data
public class RunTestResponse {
    private String reportFileName;
    private List<TestSuiteReport> testSuiteReports;
}
