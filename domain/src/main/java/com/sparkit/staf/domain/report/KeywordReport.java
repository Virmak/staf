package com.sparkit.staf.domain.report;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class KeywordReport extends StatementReport {
    protected String keywordName;
    protected String argsList;
}
