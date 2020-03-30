package com.sparkit.staf.core.runtime.interpreter.exceptions;

public abstract class AbstractInterpreterException extends Exception {
    public AbstractInterpreterException() {}
    public AbstractInterpreterException(String message) {
        super(message);
    }
}
