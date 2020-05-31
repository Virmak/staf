package com.sparkit.staf.core.runtime.interpreter.expression;

import com.sparkit.staf.core.ast.Expression;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.StafDouble;
import com.sparkit.staf.core.runtime.interpreter.exceptions.InvalidExpressionOperationParams;

public class MultiplicationExpressionEvaluator implements ExpressionEvaluator {
    @Override
    public AbstractStafObject evaluate(Expression expression) throws InvalidExpressionOperationParams {
        double expressionLeftMemberValue = Double.parseDouble(expression.getExpressionLeftMember().getValue().toString());
        double expressionRightMemberValue = Double.parseDouble(expression.getExpressionRightMember().getValue().toString());
        return new StafDouble(expressionLeftMemberValue * expressionRightMemberValue);
    }
}
