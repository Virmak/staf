package com.sparkit.staf.core.ast.exceptions;

public class InvalidIteratorTypeException extends Exception {
    public InvalidIteratorTypeException() {
        super("Iterator must be of type List or Dictionary");
    }
}
