package com.sparkit.staf.types.Exception;

public class InvalidIteratorTypeException extends Exception {
    public InvalidIteratorTypeException() {
        super("Iterator must be of type List or Dictionary");
    }
}
