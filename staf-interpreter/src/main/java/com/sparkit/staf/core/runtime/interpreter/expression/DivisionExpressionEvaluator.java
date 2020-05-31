package com.sparkit.staf.core.runtime.interpreter.expression;

import com.sparkit.staf.core.ast.Expression;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.StafDouble;
import com.sparkit.staf.core.runtime.interpreter.exceptions.InvalidExpressionOperationParams;

public class DivisionExpressionEvaluator implements ExpressionEvaluator {
    @Override
    public AbstractStafObject evaluate(Expression expression) throws InvalidExpressionOperationParams {
        double expressionLeftMemberValue = (double) expression.getExpressionLeftMember().getValue();
        double expressionRightMemberValue = (double) expression.getExpressionRightMember().getValue();
        return new StafDouble(expressionLeftMemberValue / expressionRightMemberValue);
    }
}
