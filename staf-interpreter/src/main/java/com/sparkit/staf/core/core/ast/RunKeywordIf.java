package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.KeywordCall;
import com.sparkit.staf.core.ast.types.StafBoolean;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;

public class RunKeywordIf implements IStatement {
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
    public Object execute(SymbolsTable globalSymTable, SymbolsTable localSymTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        StafBoolean conditionResult = (StafBoolean) condition.evaluate(globalSymTable, localSymTable, keywordLibrariesRepository);
        if ((Boolean) conditionResult.getValue()) {
            keywordCall.execute(globalSymTable, localSymTable, keywordLibrariesRepository);
        }
        return null;
    }
}
