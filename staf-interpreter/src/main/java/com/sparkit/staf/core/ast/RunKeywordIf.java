package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.KeywordCall;
import com.sparkit.staf.core.ast.types.StafBoolean;
import com.sparkit.staf.core.runtime.interpreter.StatementBlockExecutor;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.reports.IReportableBlock;
import com.sparkit.staf.core.runtime.reports.StatementReport;
import lombok.Getter;

import java.util.List;

public class RunKeywordIf implements IStatement, IReportableBlock {
    @Getter
    private final AbstractStafObject condition;
    @Getter
    private final KeywordCall keywordCall;
    private List<StatementReport> reports;

    public RunKeywordIf(AbstractStafObject condition, KeywordCall keywordCall) {
        this.condition = condition;
        this.keywordCall = keywordCall;
    }

    @Override
    public Object execute(SymbolsTable globalSymbolsTable, SymbolsTable localSymbolsTable) throws Throwable {
        StafBoolean conditionResult = (StafBoolean)
                condition.evaluate(globalSymbolsTable, localSymbolsTable);
        if ((Boolean) conditionResult.getValue()) {
            keywordCall.execute(globalSymbolsTable, localSymbolsTable);
        }
        return null;
    }

    @Override
    public List<StatementReport> getStatementReports() {
        return null;
    }

    @Override
    public void setStatementReports(List<StatementReport> reports) {

    }
}
