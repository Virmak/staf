package com.sparkit.interpreter.runtime.exceptions;

public class UndefinedVariableException extends StafRuntimeException {
    public UndefinedVariableException(String varName) {
        super("Variable '" + varName + "' not defined");
    }
}
