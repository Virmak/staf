package com.sparkit.staf.runtime.interpreter.exceptions;

public class UndefinedKeywordException extends AbstractInterpreterException {
    public UndefinedKeywordException(String keywordName) {
        super("Keyword '" + keywordName + "' not defined");
    }
}
