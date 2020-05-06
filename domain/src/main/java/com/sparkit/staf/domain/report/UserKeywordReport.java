package com.sparkit.staf.domain.report;

import lombok.Data;

import java.util.List;

@Data
public class KeywordCallReport extends StatementReport {
    private List<StatementReport> statementReports;
}
