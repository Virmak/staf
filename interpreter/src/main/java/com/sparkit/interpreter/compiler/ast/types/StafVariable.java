package com.sparkit.interpreter.compiler.ast.types;

import com.sparkit.interpreter.compiler.ast.StafTypes;

public class StafVariable extends AbstractStafObject {
    public StafVariable(Object value) {
        super(value, StafTypes.VAR_REF);
    }

}
