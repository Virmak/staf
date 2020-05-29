package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.runtime.interpreter.StatementBlockExecutor;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;

public class ExitLoopStatement implements IStatement{
    private AbstractStafObject condition;

    public ExitLoopStatement(AbstractStafObject condition) {
        this.condition = condition;
    }

    public ExitLoopStatement() {}

    @Override
    public Object execute(StatementBlockExecutor blockExecutor, SymbolsTable globalSymbolsTable, SymbolsTable localSymbolsTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        return null;
    }

    public AbstractStafObject getCondition() {
        return condition;
    }
}
