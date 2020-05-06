package com.sparkit.interpreter.compiler.ast.types;

import com.sparkit.interpreter.compiler.ast.StafTypes;

public class StafBoolean extends AbstractStafObject {
    public StafBoolean(boolean value) {
        super(value, StafTypes.BOOL);
    }
}
