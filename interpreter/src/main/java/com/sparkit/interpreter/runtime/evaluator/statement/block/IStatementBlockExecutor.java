package com.sparkit.interpreter.runtime.evaluator.statement.block;

import com.sparkit.interpreter.compiler.ast.statement.StafCallable;
import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.runtime.SymbolsTable;

public interface IStatementBlockExecutor<T extends StafCallable> {
    AbstractStafObject execute(T statementBlock, SymbolsTable parentLocalSymTable);
}
