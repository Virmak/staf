package com.sparkit.staf.runtime.interpreter.exceptions;

public class NullStafVariableException extends AbstractInterpreterException {
    public NullStafVariableException(String varName) {
        super("Referencing a null variable '" + varName + "'");
    }
}
