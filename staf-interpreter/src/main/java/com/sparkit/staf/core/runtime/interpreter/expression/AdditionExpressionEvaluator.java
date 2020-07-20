package com.sparkit.staf.core.runtime.interpreter.expression;

import com.sparkit.staf.core.ast.ExpressionOperator;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.StafDouble;
import com.sparkit.staf.core.ast.types.StafInteger;
import com.sparkit.staf.core.ast.types.StafString;
import org.springframework.stereotype.Component;

@Component
public class AdditionExpressionEvaluator implements ExpressionEvaluator {
    @Override
    public AbstractStafObject evaluate(AbstractStafObject expressionLeftMember, AbstractStafObject expressionRightMember, ExpressionOperator operator) {
        if (expressionLeftMember.getValue() instanceof String || expressionRightMember.getValue() instanceof String) {
            return new StafString(expressionLeftMember.getValue().toString() + expressionRightMember.getValue());
        } else if (expressionLeftMember.getValue() instanceof Double || expressionRightMember.getValue() instanceof Double) {
            double expressionLeftMemberValue = Double.parseDouble(expressionLeftMember.getValue().toString());
            double expressionRightMemberValue = Double.parseDouble(expressionRightMember.getValue().toString());
            return new StafDouble(expressionLeftMemberValue + expressionRightMemberValue);
        } else if (expressionLeftMember.getValue() instanceof Integer) {
            return new StafInteger((int) expressionLeftMember.getValue() + (int) expressionRightMember.getValue());
        }
        return null;
    }
}
