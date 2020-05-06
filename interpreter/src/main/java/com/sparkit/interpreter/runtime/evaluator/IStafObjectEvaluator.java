package com.sparkit.interpreter.runtime.evaluator;

import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.runtime.SymbolsTable;
import com.sparkit.interpreter.runtime.exceptions.UndefinedVariableException;

public interface IStafObjectEvaluator<T> {
    AbstractStafObject evaluate(T object, SymbolsTable localSymTable) throws Throwable;
}
