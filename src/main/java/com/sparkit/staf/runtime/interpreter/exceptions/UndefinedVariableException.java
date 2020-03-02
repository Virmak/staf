package com.sparkit.staf.runtime.interpreter.exceptions;

public class UndefinedVariableException extends Exception {
    public UndefinedVariableException(String varName) {
        super("Variable '" + varName + "' not defined");
    }
}
