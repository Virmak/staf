package com.sparkit.interpreter.runtime.evaluator.statement;

import com.sparkit.interpreter.compiler.ast.statement.IStatement;
import com.sparkit.interpreter.runtime.SymbolsTable;

public interface IStatementExecutor<T extends IStatement, R> {
    R execute(T statement, SymbolsTable localSymbolTable) throws Throwable;
}
