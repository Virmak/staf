package com.sparkit.staf.runtime;

import com.sparkit.staf.ast.types.AbstractStafObject;
import com.sparkit.staf.ast.types.StafDouble;
import com.sparkit.staf.ast.types.StafInteger;

public class ExpressionEvaluator {
    public static AbstractStafObject add(AbstractStafObject left, AbstractStafObject right) {
        if (left.getValue() instanceof Double || right.getValue() instanceof Double) {
            Double l = (Double) left.getValue();
            Double r = (Double) right.getValue();
            return new StafDouble(l + r);
        } else {
            return new StafInteger((Integer)left.getValue() + (Integer)right.getValue());
        }
    }

    public static AbstractStafObject substract(AbstractStafObject left, AbstractStafObject right) {
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
}
