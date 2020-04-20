package com.sparkit.staf.core.runtime.reports;

import java.util.List;

public interface ITestReportWriter {
    void write(String filPath, List<TestSuiteReport> reports);
}
