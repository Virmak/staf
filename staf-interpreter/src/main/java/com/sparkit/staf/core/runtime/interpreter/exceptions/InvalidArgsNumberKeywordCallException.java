package com.sparkit.staf.core.runtime.interpreter.exceptions;

public class InvalidArgsNumberKeywordCallException extends Exception {
    public InvalidArgsNumberKeywordCallException(int expected, int found, String keywordName) {
        super("Invalid number of arguments passed to keyword call : " + keywordName + " expected " + expected
                + " but found " + found);
    }
}
