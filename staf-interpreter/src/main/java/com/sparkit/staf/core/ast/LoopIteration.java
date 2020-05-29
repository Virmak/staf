package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.runtime.interpreter.StatementBlockExecutor;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;

// Used to create iteration report
public class LoopIteration implements IStatement {
    AbstractStafObject val;
    public LoopIteration(AbstractStafObject val) {
        this.val = val;
    }
    @Override
    public Object execute(StatementBlockExecutor blockExecutor, SymbolsTable globalSymbolsTable, SymbolsTable localSymbolsTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        return null;
    }
}
