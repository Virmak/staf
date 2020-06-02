package com.sparkit.staf.core.runtime.interpreter.exceptions;

public class UndefinedKeywordException extends StafRuntimeException {
    public UndefinedKeywordException(String keywordName) {
        super("Keyword '" + keywordName + "' not defined");
    }
}
