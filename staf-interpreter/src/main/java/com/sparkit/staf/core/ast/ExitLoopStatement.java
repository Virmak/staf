package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.runtime.interpreter.StatementBlockExecutor;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;

public class ExitLoopStatement implements IStatement{
    @Override
    public Object execute(StatementBlockExecutor blockExecutor, SymbolsTable globalSymTable, SymbolsTable localSymTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        return null;
    }
}
