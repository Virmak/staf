package com.sparkit.staf.core.parser;

public class SyntaxErrorException extends Exception {

    private String file;
    private String message;
    private int line;
    private int column;

    public SyntaxErrorException(String file, String message) {
        super("Syntax error at : " + file +  " : " + message);
    }
}
