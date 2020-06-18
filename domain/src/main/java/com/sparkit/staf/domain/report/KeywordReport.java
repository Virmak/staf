package com.sparkit.staf.domain.report;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class KeywordReport extends StatementReport {
    protected String keywordName;
    protected List<String> argsList;
}
