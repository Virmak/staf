package com.sparkit.staf.core.runtime.interpreter.expression;

import com.sparkit.staf.core.ast.Expression;
import com.sparkit.staf.core.ast.ExpressionOperator;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.StafDouble;
import com.sparkit.staf.core.ast.types.StafInteger;
import com.sparkit.staf.core.runtime.interpreter.exceptions.InvalidExpressionOperationParams;
import org.springframework.stereotype.Component;

import javax.naming.OperationNotSupportedException;

@Component
public class SubtractionExpressionEvaluator implements ExpressionEvaluator {
    @Override
    public AbstractStafObject evaluate(AbstractStafObject expressionLeftMember, AbstractStafObject expressionRightMember, ExpressionOperator operator) throws InvalidExpressionOperationParams, OperationNotSupportedException {
        if (expressionLeftMember.getValue() instanceof Double || expressionRightMember.getValue() instanceof Double) {
            double expressionLeftMemberValue = (double) expressionLeftMember.getValue();
            double expressionRightMemberValue = (double) expressionRightMember.getValue();
            return new StafDouble(expressionLeftMemberValue - expressionRightMemberValue);
        } else {
            return new StafInteger((int) expressionLeftMember.getValue() - (int) expressionRightMember.getValue());
        }
    }
}
