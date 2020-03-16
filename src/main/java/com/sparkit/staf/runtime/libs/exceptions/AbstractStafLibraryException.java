package com.sparkit.staf.runtime.libs.exceptions;

public abstract class AbstractStafLibraryException extends Exception {
    public AbstractStafLibraryException() {}
    public AbstractStafLibraryException(String message) {
        super(message);
    }
}
