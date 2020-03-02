package com.sparkit.staf.runtime.libs.exceptions;

public class KeywordAlreadyRegisteredException extends Exception {
    public KeywordAlreadyRegisteredException(String keywordName) {
        super("Keyword with the name '" + keywordName + "' already registered");
    }
}
