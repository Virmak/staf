package com.sparkit.staf.domain.report;

import com.sparkit.staf.domain.TestResult;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class StatementReport {
    protected String name;
    protected List<StatementReport> childReports;
    protected TestResult result;
    protected String errorMessage;
    protected String screenShotAttachment;
    protected Date start;
    protected Date end;

}
