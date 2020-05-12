package com.sparkit.staf.core.runtime.interpreter.ast;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;

public interface INodeEvaluator<T> {
    public AbstractStafObject evaluate(T node, SymbolsTable globalSymTable, SymbolsTable localSymTable) throws Throwable;
}
