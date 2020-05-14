package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.runtime.reports.StatementReport;

public interface OnStatementFailed {
    void execute(StatementReport statementReport);
}
