package com.sparkit.staf.core.runtime.interpreter.exceptions;

public class VariableAlreadyDefinedException extends StafRuntimeException {
    public VariableAlreadyDefinedException(String varName) {
        super("Variable '" + varName + "' already defined");
    }
}
