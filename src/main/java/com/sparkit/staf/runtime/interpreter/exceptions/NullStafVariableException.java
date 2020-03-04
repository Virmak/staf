package com.sparkit.staf.runtime.interpreter.exceptions;

public class NullStafVariableException extends Exception {
    public NullStafVariableException(String varName) {
        super("Referencing a null variable '" + varName + "'");
    }
}
