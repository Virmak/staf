package com.sparkit.staf.core.runtime.reports;

import java.util.List;

public interface IReportableBlock {
    List<StatementReport> getStatementReports();
    void setStatementReports(List<StatementReport> reports);
}
