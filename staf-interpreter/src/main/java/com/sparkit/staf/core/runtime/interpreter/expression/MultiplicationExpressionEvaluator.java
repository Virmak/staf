package com.sparkit.staf.core.runtime.interpreter.expression;

import com.sparkit.staf.core.ast.ExpressionOperator;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.StafDouble;
import org.springframework.stereotype.Component;

@Component
public class MultiplicationExpressionEvaluator implements ExpressionEvaluator {
    @Override
    public AbstractStafObject evaluate(AbstractStafObject expressionLeftMember, AbstractStafObject expressionRightMember, ExpressionOperator operator) {
        double expressionLeftMemberValue = (double) expressionLeftMember.getValue();
        double expressionRightMemberValue = (double) expressionRightMember.getValue();
        return new StafDouble(expressionLeftMemberValue * expressionRightMemberValue);
    }
}
