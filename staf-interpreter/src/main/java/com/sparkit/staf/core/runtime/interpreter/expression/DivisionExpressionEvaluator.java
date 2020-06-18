package com.sparkit.staf.core.runtime.interpreter.expression;

import com.sparkit.staf.core.ast.ExpressionOperator;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.StafDouble;
import com.sparkit.staf.core.runtime.interpreter.exceptions.InvalidExpressionOperationParams;
import org.springframework.stereotype.Component;

import javax.naming.OperationNotSupportedException;

@Component
public class DivisionExpressionEvaluator implements ExpressionEvaluator {
    @Override
    public AbstractStafObject evaluate(AbstractStafObject expressionLeftMember, AbstractStafObject expressionRightMember, ExpressionOperator operator) throws InvalidExpressionOperationParams, OperationNotSupportedException {
        double expressionLeftMemberValue = (double) expressionLeftMember.getValue();
        double expressionRightMemberValue = (double) expressionRightMember.getValue();
        return new StafDouble(expressionLeftMemberValue / expressionRightMemberValue);
    }
}
