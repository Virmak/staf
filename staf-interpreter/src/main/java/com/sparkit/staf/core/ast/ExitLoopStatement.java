package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import lombok.Getter;

public class ExitLoopStatement implements IStatement {
    @Getter
    private AbstractStafObject condition;

    public ExitLoopStatement(AbstractStafObject condition) {
        this.condition = condition;
    }

    public ExitLoopStatement() {
    }

    @Override
    public Object execute(SymbolsTable globalSymbolsTable, SymbolsTable localSymbolsTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        return null;
    }
}
