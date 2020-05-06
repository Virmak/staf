package com.sparkit.interpreter.compiler.ast.types;

import com.sparkit.interpreter.compiler.ast.StafTypes;

public class StafDouble extends AbstractStafObject {
    public StafDouble(double value) {
        super(value, StafTypes.DOUBLE);
    }

}
