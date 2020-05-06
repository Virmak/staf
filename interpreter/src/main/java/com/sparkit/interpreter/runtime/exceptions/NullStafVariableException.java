package com.sparkit.interpreter.runtime.exceptions;

public class NullStafVariableException extends StafRuntimeException {
    public NullStafVariableException(String varName) {
        super("Referencing a null variable '" + varName + "'");
    }
}
