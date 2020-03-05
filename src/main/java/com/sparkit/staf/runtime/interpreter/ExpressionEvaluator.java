package com.sparkit.staf.runtime.interpreter;

import com.sparkit.staf.ast.types.AbstractStafObject;
import com.sparkit.staf.ast.types.StafBoolean;
import com.sparkit.staf.ast.types.StafDouble;
import com.sparkit.staf.ast.types.StafInteger;
import com.sparkit.staf.runtime.interpreter.exceptions.InvalidExpressionOperationParams;

public class ExpressionEvaluator {
    public static AbstractStafObject add(AbstractStafObject left, AbstractStafObject right) {
        if (left.getValue() instanceof Double || right.getValue() instanceof Double) {
            Double l = (Double) left.getValue();
            Double r = (Double) right.getValue();
            return new StafDouble(l + r);
        }
        else {
            return new StafInteger((Integer)left.getValue() + (Integer)right.getValue());
        }
    }

    public static AbstractStafObject subtract(AbstractStafObject left, AbstractStafObject right) {
        if (left.getValue() instanceof Double || right.getValue() instanceof Double) {
            Double l = (Double) left.getValue();
            Double r = (Double) right.getValue();
            return new StafDouble(l - r);
        } else {
            return new StafInteger((Integer)left.getValue() - (Integer)right.getValue());
        }
    }

    public static AbstractStafObject multiply(AbstractStafObject left, AbstractStafObject right) {
        if (left.getValue() instanceof Double || right.getValue() instanceof Double) {
            Double l = (Double) left.getValue();
            Double r = (Double) right.getValue();
            return new StafDouble(l * r);
        } else {
            return new StafInteger((Integer)left.getValue() * (Integer)right.getValue());
        }
    }

    public static AbstractStafObject div(AbstractStafObject left, AbstractStafObject right) {
        Double l = (Double) left.getValue();
        Double r = (Double) right.getValue();
        return new StafDouble(l / r);
    }

    public static AbstractStafObject greaterThan(AbstractStafObject left, AbstractStafObject right) throws InvalidExpressionOperationParams {
        if (left.getValue() instanceof Double || right.getValue() instanceof Double) {
            Double l = (Double) left.getValue();
            Double r = (Double) right.getValue();
            return new StafBoolean(l > r);
        } else if (left.getValue() instanceof String || right.getValue() instanceof String) {
            throw new InvalidExpressionOperationParams();
        } else {
            return new StafBoolean((Integer)left.getValue() > (Integer)right.getValue());
        }
    }

    public static AbstractStafObject lessThan(AbstractStafObject left, AbstractStafObject right) throws InvalidExpressionOperationParams {
        if (left.getValue() instanceof Double || right.getValue() instanceof Double) {
            Double l = (Double) left.getValue();
            Double r = (Double) right.getValue();
            return new StafBoolean(l < r);
        }  else if (left.getValue() instanceof String || right.getValue() instanceof String) {
            throw new InvalidExpressionOperationParams();
        } else {
            return new StafBoolean((Integer)left.getValue() < (Integer)right.getValue());
        }
    }

    public static AbstractStafObject greaterThanOrEqual(AbstractStafObject left, AbstractStafObject right) throws InvalidExpressionOperationParams {
        if (left.getValue() instanceof Double || right.getValue() instanceof Double) {
            Double l = (Double) left.getValue();
            Double r = (Double) right.getValue();
            return new StafBoolean(l >= r);
        } else if (left.getValue() instanceof String || right.getValue() instanceof String) {
            throw new InvalidExpressionOperationParams();
        } else {
            return new StafBoolean((Integer)left.getValue() >= (Integer)right.getValue());
        }
    }

    public static AbstractStafObject lessThanOrEqual(AbstractStafObject left, AbstractStafObject right) throws InvalidExpressionOperationParams {
        if (left.getValue() instanceof Double || right.getValue() instanceof Double) {
            Double l = (Double) left.getValue();
            Double r = (Double) right.getValue();
            return new StafBoolean(l <= r);
        } else if (left.getValue() instanceof String || right.getValue() instanceof String) {
            throw new InvalidExpressionOperationParams();
        } else {
            return new StafBoolean((Integer)left.getValue() <= (Integer)right.getValue());
        }
    }

    public static AbstractStafObject notEqual(AbstractStafObject left, AbstractStafObject right) {
        return new StafBoolean(left.getValue().toString().equals(right.getValue().toString()));
    }
}
