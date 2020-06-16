package com.sparkit.staf.core.runtime.libs.exceptions;

public class ShouldNotBeEqualException extends AbstractStafLibraryException {
    public ShouldNotBeEqualException(String message) {
        super("Should not be equal, condition not satisfied : " + message);
    }
}
