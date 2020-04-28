package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.KeywordCall;
import com.sparkit.staf.core.ast.types.StafBoolean;
import com.sparkit.staf.core.runtime.interpreter.StatementBlockExecutor;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.reports.IReportableBlock;

public class RunKeywordIf extends KeywordCall implements IStatement, IReportableBlock {
    protected AbstractStafObject condition;
    protected KeywordCall keywordCall;

    public RunKeywordIf() {
    }

    public RunKeywordIf(AbstractStafObject condition, KeywordCall keywordCall) {
        this.condition = condition;
        this.keywordCall = keywordCall;
    }

    public AbstractStafObject getCondition() {
        return condition;
    }

    public void setCondition(AbstractStafObject condition) {
        this.condition = condition;
    }

    public KeywordCall getKeywordCall() {
        return keywordCall;
    }

    public void setKeywordCall(KeywordCall keywordCall) {
        this.keywordCall = keywordCall;
    }

    @Override
    public Object execute(StatementBlockExecutor blockExecutor, SymbolsTable globalSymTable, SymbolsTable localSymTable,
                          KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        StafBoolean conditionResult = (StafBoolean)
                condition.evaluate(blockExecutor, globalSymTable, localSymTable,keywordLibrariesRepository);
        if ((Boolean) conditionResult.getValue()) {
            keywordCall.execute(blockExecutor, globalSymTable, localSymTable, keywordLibrariesRepository);
        }
        return null;
    }
}
