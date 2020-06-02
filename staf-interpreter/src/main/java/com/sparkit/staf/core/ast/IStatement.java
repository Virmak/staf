package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;

public interface IStatement {
    Object execute(SymbolsTable globalSymbolsTable, SymbolsTable localSymbolsTable) throws Throwable;
}
