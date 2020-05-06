package com.sparkit.interpreter.runtime.libs.exceptions;

public abstract class AbstractStafLibraryException extends RuntimeException {
    public AbstractStafLibraryException() {}
    public AbstractStafLibraryException(String message) {
        super(message);
    }
}
