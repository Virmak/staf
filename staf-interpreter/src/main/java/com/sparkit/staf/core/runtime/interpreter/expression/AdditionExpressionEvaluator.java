package com.sparkit.staf.core.runtime.interpreter.expression;

import com.sparkit.staf.core.ast.Expression;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.StafDouble;
import com.sparkit.staf.core.ast.types.StafInteger;
import com.sparkit.staf.core.ast.types.StafString;
import com.sparkit.staf.core.runtime.interpreter.exceptions.InvalidExpressionOperationParams;

public class AdditionExpressionEvaluator implements ExpressionEvaluator {
    @Override
    public AbstractStafObject evaluate(Expression expression) throws InvalidExpressionOperationParams {
        if (expression.getExpressionLeftMember().getValue() instanceof String || expression.getExpressionRightMember().getValue() instanceof String) {
            return new StafString(expression.getExpressionLeftMember().getValue().toString() + expression.getExpressionRightMember().getValue());
        } else if (expression.getExpressionLeftMember().getValue() instanceof Double || expression.getExpressionRightMember().getValue() instanceof Double) {
            double expressionLeftMemberValue = Double.parseDouble(expression.getExpressionLeftMember().getValue().toString());
            double expressionRightMemberValue = Double.parseDouble(expression.getExpressionRightMember().getValue().toString());
            return new StafDouble(expressionLeftMemberValue + expressionRightMemberValue);
        } else if (expression.getExpressionLeftMember().getValue() instanceof Integer) {
            return new StafInteger((int) expression.getExpressionLeftMember().getValue() + (int) expression.getExpressionRightMember().getValue());
        }
        return null;
    }
}
