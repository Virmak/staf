package com.sparkit.staf.core.parser;

public class SyntaxErrorException extends Exception {
    public SyntaxErrorException(String file, String message) {
        super("Syntax error at : " + file + " : " + message);
    }
}
