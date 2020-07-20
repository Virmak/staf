package com.sparkit.staf.core.runtime.interpreter.exceptions;

import com.sparkit.staf.core.runtime.reports.StatementReport;
import lombok.Getter;

import java.util.List;

public class FatalErrorException extends StafRuntimeException {
    @Getter
    private final List<StatementReport> reports;

    public FatalErrorException(List<StatementReport> reports, Throwable cause) {
        super(cause);
        this.reports = reports;
    }

}
