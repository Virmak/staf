package com.sparkit.staf.domain.report;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TestCaseReport extends StatementReport {
    protected String testCase;
    protected String documentation;
}
