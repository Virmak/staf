package com.sparkit.staf.core.runtime.interpreter.expression;

import com.sparkit.staf.core.ast.Expression;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.StafDouble;
import com.sparkit.staf.core.ast.types.StafInteger;
import org.springframework.stereotype.Component;

@Component
public class SubtractionExpressionEvaluator implements ExpressionEvaluator {
    @Override
    public AbstractStafObject evaluate(Expression expression) {
        if (expression.getExpressionLeftMember().getValue() instanceof Double || expression.getExpressionRightMember().getValue() instanceof Double) {
            double expressionLeftMemberValue = (double) expression.getExpressionLeftMember().getValue();
            double expressionRightMemberValue = (double) expression.getExpressionRightMember().getValue();
            return new StafDouble(expressionLeftMemberValue - expressionRightMemberValue);
        } else {
            return new StafInteger((int) expression.getExpressionLeftMember().getValue() - (int) expression.getExpressionRightMember().getValue());
        }
    }
}
