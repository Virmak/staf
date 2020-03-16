package com.sparkit.staf.runtime.libs.exceptions;

public class ShouldBeEqualException extends AbstractStafLibraryException {
    public ShouldBeEqualException(String message) {
        super("Should be equal, condition not satisfied : " + message);
    }
}
