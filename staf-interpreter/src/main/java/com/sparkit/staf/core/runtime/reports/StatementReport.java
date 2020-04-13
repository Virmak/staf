package com.sparkit.staf.core.runtime.reports;

import com.sparkit.staf.core.ast.IStatement;
import com.sparkit.staf.domain.TestResult;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class StatementReport {
    private IStatement statement;
    private List<StatementReport> children;
    private TestResult result;
    private String errorMessage;
    private String screenShot;
    private Date start;
    private Date end;
}
