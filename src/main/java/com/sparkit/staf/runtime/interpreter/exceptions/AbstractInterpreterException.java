package com.sparkit.staf.runtime.interpreter.exceptions;

public abstract class AbstractInterpreterException extends Exception {
    public AbstractInterpreterException() {}
    public AbstractInterpreterException(String message) {
        super(message);
    }
}
