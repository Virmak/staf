package com.sparkit.staf.core.runtime.interpreter.expression;

import com.sparkit.staf.core.ast.ExpressionOperator;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.StafBoolean;
import com.sparkit.staf.core.runtime.interpreter.exceptions.InvalidExpressionOperationParams;
import org.springframework.stereotype.Component;

import javax.naming.OperationNotSupportedException;

@Component
public class BooleanExpressionEvaluator implements ExpressionEvaluator {
    @Override
    public AbstractStafObject evaluate(AbstractStafObject expressionLeftMember, AbstractStafObject expressionRightMember, ExpressionOperator operator)
            throws InvalidExpressionOperationParams, OperationNotSupportedException {
        if (expressionLeftMember.getValue() instanceof String || expressionRightMember.getValue() instanceof String) {
            throw new InvalidExpressionOperationParams();
        } else if (expressionLeftMember.getValue() instanceof Double || expressionRightMember.getValue() instanceof Double
                || expressionLeftMember.getValue() instanceof Integer || expressionRightMember.getValue() instanceof Integer) {
            double expressionLeftMemberValue = Double.parseDouble(expressionLeftMember.getValue().toString());
            double expressionRightMemberValue = Double.parseDouble(expressionRightMember.getValue().toString());
            return new StafBoolean(compareNumbers(expressionLeftMemberValue, expressionRightMemberValue, operator));
        }
        throw new InvalidExpressionOperationParams();
    }

    private boolean compareNumbers(double expressionLeftMember, double expressionRightMember, ExpressionOperator operator) throws OperationNotSupportedException {
        switch (operator) {
            case EQUAL:
                return expressionLeftMember == expressionRightMember;
            case GT:
                return expressionLeftMember > expressionRightMember;
            case LT:
                return expressionLeftMember < expressionRightMember;
            case NE:
                return expressionLeftMember != expressionRightMember;
            case GTE:
                return expressionLeftMember >= expressionRightMember;
            case LTE:
                return expressionLeftMember <= expressionRightMember;
            default:
                throw new OperationNotSupportedException();
        }
    }
}
