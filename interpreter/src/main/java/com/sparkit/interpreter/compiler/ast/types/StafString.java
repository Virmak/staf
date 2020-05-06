package com.sparkit.interpreter.compiler.ast.types;


import com.sparkit.interpreter.compiler.ast.StafTypes;

public class StafString extends AbstractStafObject {
    public StafString(String value) {
        super(value, StafTypes.STRING);
    }
    @Override
    public String toString() {
        return "\"" + value + "\"";
    }
}
