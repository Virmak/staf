package com.sparkit.interpreter.runtime.evaluator;

import com.sparkit.interpreter.compiler.ast.Expression;
import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.runtime.SymbolsTable;

public class ExpressionEvaluator implements IStafObjectEvaluator<Expression> {
    @Override
    public AbstractStafObject evaluate(Expression object, SymbolsTable localSymTable) throws Throwable {
        throw new Exception("not implemented");
    }
}
