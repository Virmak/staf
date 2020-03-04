package com.sparkit.staf.runtime.interpreter.exceptions;

public class VariableAlreadyDefinedException extends Exception {
    public VariableAlreadyDefinedException(String varName) {
        super("Variable '" + varName + "' already defined");
    }
}
