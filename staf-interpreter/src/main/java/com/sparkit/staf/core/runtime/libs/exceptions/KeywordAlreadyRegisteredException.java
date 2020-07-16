package com.sparkit.staf.core.runtime.libs.exceptions;

import lombok.Getter;

public class KeywordAlreadyRegisteredException extends AbstractStafLibraryException {
    @Getter
    private String keywordName;

    public KeywordAlreadyRegisteredException(String keywordName) {
        super("Keyword with the name '" + keywordName + "' already registered");
        this.keywordName = keywordName;
    }
}
