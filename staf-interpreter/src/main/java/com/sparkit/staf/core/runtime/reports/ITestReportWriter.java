package com.sparkit.staf.core.runtime.reports;

import com.sparkit.staf.domain.ProjectConfig;

import java.util.List;

public interface ITestReportWriter {
    void write(ProjectConfig projectConfig, String testSuiteName, List<TestSuiteReport> reports);
}
