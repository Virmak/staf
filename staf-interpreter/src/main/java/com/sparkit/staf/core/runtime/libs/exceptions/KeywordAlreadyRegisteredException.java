package com.sparkit.staf.core.runtime.libs.exceptions;

import com.sparkit.staf.core.ast.KeywordDeclaration;
import lombok.Getter;

public class KeywordAlreadyRegisteredException extends AbstractStafLibraryException {
    @Getter
    private String keywordName;
    @Getter
    private KeywordDeclaration firstKeyword;
    @Getter
    private KeywordDeclaration secondKeyword;

    public KeywordAlreadyRegisteredException(String keywordName) {
        super("Keyword with the name '" + keywordName + "' already registered");
        this.keywordName = keywordName;
    }

    public KeywordAlreadyRegisteredException(String keywordName, String libraryName) {
        super("Keyword with the name '" + keywordName + "' already registered in " + libraryName);
        this.keywordName = keywordName;
    }

    public KeywordAlreadyRegisteredException(KeywordDeclaration firstKeyword, KeywordDeclaration secondKeyword) {
        super("Another keyword with the same name already exists at " + secondKeyword.getTokenPosition().getFilePath() + " line " + secondKeyword.getTokenPosition().getLine());
        this.firstKeyword = firstKeyword;
        this.secondKeyword = secondKeyword;
    }
}
