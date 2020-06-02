package com.sparkit.staf.core.runtime.interpreter.expression;

import com.sparkit.staf.core.ast.Expression;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.StafBoolean;
import com.sparkit.staf.core.runtime.interpreter.exceptions.InvalidExpressionOperationParams;
import org.springframework.stereotype.Component;

import javax.naming.OperationNotSupportedException;

@Component
public class BooleanExpressionEvaluator implements ExpressionEvaluator {
    @Override
    public AbstractStafObject evaluate(Expression expression) throws InvalidExpressionOperationParams, OperationNotSupportedException {
        if (expression.getExpressionLeftMember().getValue() instanceof String || expression.getExpressionRightMember().getValue() instanceof String) {
            throw new InvalidExpressionOperationParams();
        } else if (expression.getExpressionLeftMember().getValue() instanceof Double || expression.getExpressionRightMember().getValue() instanceof Double
        || expression.getExpressionLeftMember().getValue() instanceof Integer || expression.getExpressionRightMember().getValue() instanceof Integer) {
            return new StafBoolean(compareNumbers(expression));
        }
        throw new InvalidExpressionOperationParams();
    }

    private boolean compareNumbers(Expression expression) throws OperationNotSupportedException {
        switch (expression.getOperation()) {
            case EQUAL:
                return (double) expression.getExpressionLeftMember().getValue() == (double) expression.getExpressionRightMember().getValue();
            case GT:
                return (double) expression.getExpressionLeftMember().getValue() > (double) expression.getExpressionRightMember().getValue();
            case LT:
                return (double) expression.getExpressionLeftMember().getValue() < (double) expression.getExpressionRightMember().getValue();
            case NE:
                return (double) expression.getExpressionLeftMember().getValue() != (double) expression.getExpressionRightMember().getValue();
            case GTE:
                return (double) expression.getExpressionLeftMember().getValue() >= (double) expression.getExpressionRightMember().getValue();
            case LTE:
                return (double) expression.getExpressionLeftMember().getValue() <= (double) expression.getExpressionRightMember().getValue();
            default:
                throw new OperationNotSupportedException();
        }
    }
}
