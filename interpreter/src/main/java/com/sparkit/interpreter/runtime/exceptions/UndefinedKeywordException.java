package com.sparkit.interpreter.runtime.exceptions;

public class UndefinedKeywordException extends StafRuntimeException {
    public UndefinedKeywordException(String keywordName) {
        super("Keyword '" + keywordName + "' not defined");
    }
}
