package com.sparkit.staf.core.runtime.interpreter.expression;

import com.sparkit.staf.core.ast.types.*;
import com.sparkit.staf.core.runtime.interpreter.exceptions.InvalidExpressionOperationParams;

public class ExpressionEvaluatorO {
    public static AbstractStafObject add(AbstractStafObject expressionLeftMember, AbstractStafObject expressionRightMember) {
        if (expressionLeftMember.getValue() instanceof String || expressionRightMember.getValue() instanceof String) {
            return new StafString(expressionLeftMember.getValue().toString() + expressionRightMember.getValue());
        } else if (expressionLeftMember.getValue() instanceof Double || expressionRightMember.getValue() instanceof Double) {
            Double expressionLeftMemberValue = Double.parseDouble(expressionLeftMember.getValue().toString());
            Double expressionRightMemberValue = Double.parseDouble(expressionRightMember.getValue().toString());
            return new StafDouble(expressionLeftMemberValue + expressionRightMemberValue);
        } else if (expressionLeftMember.getValue() instanceof Integer) {
            return new StafInteger((int) expressionLeftMember.getValue() + (int) expressionRightMember.getValue());
        }
        return null;
    }

    public static AbstractStafObject subtract(AbstractStafObject expressionLeftMember, AbstractStafObject expressionRightMember) {
        if (expressionLeftMember.getValue() instanceof Double || expressionRightMember.getValue() instanceof Double) {
            Double expressionLeftMemberValue = (Double) expressionLeftMember.getValue();
            Double expressionRightMemberValue = (Double) expressionRightMember.getValue();
            return new StafDouble(expressionLeftMemberValue - expressionRightMemberValue);
        } else {
            return new StafInteger((int) expressionLeftMember.getValue() - (int) expressionRightMember.getValue());
        }
    }

    public static AbstractStafObject multiply(AbstractStafObject expressionLeftMember, AbstractStafObject expressionRightMember) {
        double expressionLeftMemberValue = Double.parseDouble(expressionLeftMember.getValue().toString());
        double expressionRightMemberValue = Double.parseDouble(expressionRightMember.getValue().toString());
        return new StafDouble(expressionLeftMemberValue * expressionRightMemberValue);
    }

    public static AbstractStafObject div(AbstractStafObject expressionLeftMember, AbstractStafObject expressionRightMember) {
        double expressionLeftMemberValue = (double) expressionLeftMember.getValue();
        double expressionRightMemberValue = (double) expressionRightMember.getValue();
        return new StafDouble(expressionLeftMemberValue / expressionRightMemberValue);
    }

    public static AbstractStafObject greaterThan(AbstractStafObject expressionLeftMember, AbstractStafObject expressionRightMember) throws InvalidExpressionOperationParams {
        if (expressionLeftMember.getValue() instanceof Double || expressionRightMember.getValue() instanceof Double) {
            double expressionLeftMemberValue = (double) expressionLeftMember.getValue();
            double expressionRightMemberValue = (double) expressionRightMember.getValue();
            return new StafBoolean(expressionLeftMemberValue > expressionRightMemberValue);
        } else if (expressionLeftMember.getValue() instanceof String || expressionRightMember.getValue() instanceof String) {
            throw new InvalidExpressionOperationParams();
        } else {
            return new StafBoolean((int) expressionLeftMember.getValue() > (int) expressionRightMember.getValue());
        }
    }

    public static AbstractStafObject lessThan(AbstractStafObject expressionLeftMember, AbstractStafObject expressionRightMember) throws InvalidExpressionOperationParams {
        if (expressionLeftMember.getValue() instanceof Double || expressionRightMember.getValue() instanceof Double) {
            double expressionLeftMemberValue = (double) expressionLeftMember.getValue();
            double expressionRightMemberValue = (double) expressionRightMember.getValue();
            return new StafBoolean(expressionLeftMemberValue < expressionRightMemberValue);
        } else if (expressionLeftMember.getValue() instanceof String || expressionRightMember.getValue() instanceof String) {
            throw new InvalidExpressionOperationParams();
        } else {
            return new StafBoolean((Integer) expressionLeftMember.getValue() < (Integer) expressionRightMember.getValue());
        }
    }

    public static AbstractStafObject greaterThanOrEqual(AbstractStafObject expressionLeftMember, AbstractStafObject expressionRightMember) throws InvalidExpressionOperationParams {
        if (expressionLeftMember.getValue() instanceof Double || expressionRightMember.getValue() instanceof Double) {
            double expressionLeftMemberValue = (double) expressionLeftMember.getValue();
            double expressionRightMemberValue = (double) expressionRightMember.getValue();
            return new StafBoolean(expressionLeftMemberValue >= expressionRightMemberValue);
        } else if (expressionLeftMember.getValue() instanceof String || expressionRightMember.getValue() instanceof String) {
            throw new InvalidExpressionOperationParams();
        } else {
            return new StafBoolean((int) expressionLeftMember.getValue() >= (int) expressionRightMember.getValue());
        }
    }

    public static AbstractStafObject lessThanOrEqual(AbstractStafObject expressionLeftMember, AbstractStafObject expressionRightMember) throws InvalidExpressionOperationParams {
        if (expressionLeftMember.getValue() instanceof Double || expressionRightMember.getValue() instanceof Double) {
            double expressionLeftMemberValue = (double) expressionLeftMember.getValue();
            double expressionRightMemberValue = (double) expressionRightMember.getValue();
            return new StafBoolean(expressionLeftMemberValue <= expressionRightMemberValue);
        } else if (expressionLeftMember.getValue() instanceof String || expressionRightMember.getValue() instanceof String) {
            throw new InvalidExpressionOperationParams();
        } else {
            return new StafBoolean((int) expressionLeftMember.getValue() <= (int) expressionRightMember.getValue());
        }
    }

    public static AbstractStafObject notEqual(AbstractStafObject expressionLeftMember, AbstractStafObject expressionRightMember) {
        return new StafBoolean(expressionLeftMember.getValue().toString().equals(expressionRightMember.getValue().toString()));
    }
}
