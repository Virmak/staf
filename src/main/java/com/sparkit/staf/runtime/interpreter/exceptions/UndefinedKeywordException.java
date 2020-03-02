package com.sparkit.staf.runtime.interpreter.exceptions;

public class UndefinedKeywordException extends Exception {
    public UndefinedKeywordException(String keywordName) {
        super("Keyword '" + keywordName + "' not defined");
    }
}
