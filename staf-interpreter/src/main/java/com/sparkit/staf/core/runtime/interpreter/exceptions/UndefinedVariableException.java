package com.sparkit.staf.core.runtime.interpreter.exceptions;

public class UndefinedVariableException extends StafRuntimeException {
    public UndefinedVariableException(String varName) {
        super("Variable '" + varName + "' not defined");
    }
}
