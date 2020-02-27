package com.sparkit.staf.types;

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
}
