package com.sparkit.staf.core.runtime.interpreter.exceptions;

public class NullStafVariableException extends StafRuntimeException {
    public NullStafVariableException(String varName) {
        super("Referencing a null variable '" + varName + "'");
    }
}
