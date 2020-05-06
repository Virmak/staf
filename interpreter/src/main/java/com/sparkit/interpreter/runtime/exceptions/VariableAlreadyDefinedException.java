package com.sparkit.interpreter.runtime.exceptions;

public class VariableAlreadyDefinedException extends StafRuntimeException {
    public VariableAlreadyDefinedException(String varName) {
        super("Variable '" + varName + "' already defined");
    }
}
