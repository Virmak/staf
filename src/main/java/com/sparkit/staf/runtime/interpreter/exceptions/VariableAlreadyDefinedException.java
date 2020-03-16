package com.sparkit.staf.runtime.interpreter.exceptions;

public class VariableAlreadyDefinedException extends AbstractInterpreterException {
    public VariableAlreadyDefinedException(String varName) {
        super("Variable '" + varName + "' already defined");
    }
}
