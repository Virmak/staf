package com.sparkit.staf.core.runtime.interpreter.exceptions;

import com.sparkit.staf.core.runtime.reports.StatementReport;

import java.util.List;

public class FatalErrorException extends StafRuntimeException {
    private List<StatementReport> reports;

    public FatalErrorException(Throwable cause) {
        super(cause);
    }

    public FatalErrorException(List<StatementReport> reports, Throwable cause) {
        super(cause);
        this.reports = reports;
    }

    public List<StatementReport> getReports() {
        return reports;
    }
}
