package com.sparkit.staf.runtime.interpreter.exceptions;

public class UndefinedVariableException extends AbstractInterpreterException {
    public UndefinedVariableException(String varName) {
        super("Variable '" + varName + "' not defined");
    }
}
