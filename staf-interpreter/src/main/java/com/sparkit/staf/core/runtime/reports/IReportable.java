package com.sparkit.staf.core.runtime.reports;

import java.util.List;

/*
    Used to get  reports of an IStatement that contains other statements
 */
public interface IReportable {
    StatementReport getReport();

    void setStatementReport(StatementReport report);
}
