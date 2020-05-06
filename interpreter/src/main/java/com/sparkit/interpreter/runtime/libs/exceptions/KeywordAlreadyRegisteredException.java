package com.sparkit.interpreter.runtime.libs.exceptions;

public class KeywordAlreadyRegisteredException extends AbstractStafLibraryException {
    public KeywordAlreadyRegisteredException(String keywordName) {
        super("Keyword with the name '" + keywordName + "' already registered");
    }
}
