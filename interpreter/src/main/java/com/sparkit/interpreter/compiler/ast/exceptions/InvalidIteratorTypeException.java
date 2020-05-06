package com.sparkit.interpreter.compiler.ast.exceptions;

public class InvalidIteratorTypeException extends Exception {
    public InvalidIteratorTypeException() {
        super("Iterator must be of type List or Dictionary");
    }
}
