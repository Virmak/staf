package com.sparkit.staf.core.runtime.interpreter.expression;

import com.sparkit.staf.core.ast.ExpressionOperator;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.runtime.interpreter.exceptions.InvalidExpressionOperationParams;

import javax.naming.OperationNotSupportedException;

public interface ExpressionEvaluator {
    AbstractStafObject evaluate(AbstractStafObject expressionLeftMember, AbstractStafObject expressionRightMember,
                                ExpressionOperator operator) throws InvalidExpressionOperationParams, OperationNotSupportedException;
}
