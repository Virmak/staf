package com.sparkit.staf.core.runtime.reports;

import com.sparkit.staf.core.ast.IStatement;
import lombok.Data;

import java.util.Date;

@Data
public class StatementReport {
    private IStatement statement;
    private TestResult result;
    private String errorMessage;
    private Date start;
    private Date end;
}
