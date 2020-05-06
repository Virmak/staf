package com.sparkit.interpreter.compiler.ast.types;

import com.sparkit.interpreter.compiler.ast.StafTypes;

public class StafInteger extends AbstractStafObject {
    public StafInteger(int value) {
        super(value, StafTypes.INT);
    }

}
