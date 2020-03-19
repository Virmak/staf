package com.sparkit.staf.core.runtime.interpreter.exceptions;

public class NullStafVariableException extends AbstractInterpreterException {
    public NullStafVariableException(String varName) {
        super("Referencing a null variable '" + varName + "'");
    }
}
