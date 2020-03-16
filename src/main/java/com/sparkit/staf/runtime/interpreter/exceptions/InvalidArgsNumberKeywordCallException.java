package com.sparkit.staf.runtime.interpreter.exceptions;

public class InvalidArgsNumberKeywordCallException extends AbstractInterpreterException {
    public InvalidArgsNumberKeywordCallException(int expected, int found, String keywordName) {
        super("Invalid number of arguments passed to keyword call : " + keywordName + " expected " + expected
                + " but found " + found);
    }
}
