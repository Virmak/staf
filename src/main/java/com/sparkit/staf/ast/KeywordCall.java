package com.sparkit.staf.ast;

import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.runtime.interpreter.exceptions.UndefinedKeywordException;

import java.util.List;

public class KeywordCall extends StafObject implements IStatement{
    protected String keywordName;
    protected List<StafObject> argumentsList;

    public KeywordCall(String keywordName, List<StafObject> argumentsList) {
        this.keywordName = keywordName;
        this.argumentsList = argumentsList;
    }

    public KeywordCall() {
    }

    public String getKeywordName() {
        return keywordName;
    }

    public void setKeywordName(String keywordName) {
        this.keywordName = keywordName;
    }

    public List<StafObject> getArgumentsList() {
        return argumentsList;
    }

    public void setArgumentsList(List<StafObject> argumentsList) {
        this.argumentsList = argumentsList;
    }

    @Override
    public Object execute(SymbolsTable globalSymTable, SymbolsTable localSymTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Exception {
        if (keywordLibrariesRepository.isKeywordDeclared(keywordName)) {
            return keywordLibrariesRepository.invokeKeyword(keywordName, argumentsList.toArray());
        } else {
            throw new UndefinedKeywordException(keywordName);
        }
    }
}
