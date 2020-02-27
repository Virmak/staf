package com.sparkit.staf.types;

import java.util.List;

public class KeywordDeclaration {
    protected String keywordName;
    protected List<String> argsList;
    protected List<AbstractStatement> statementList;
    protected StafObject returnObject;

    public KeywordDeclaration(String keywordName, List<String> argsList, List<AbstractStatement> statementList, StafObject returnObject) {
        this.keywordName = keywordName;
        this.argsList = argsList;
        this.statementList = statementList;
        this.returnObject = returnObject;
    }

    public KeywordDeclaration() {
    }

    public StafObject getReturnObject() {
        return returnObject;
    }

    public void setReturnObject(StafObject returnObject) {
        this.returnObject = returnObject;
    }

    public List<AbstractStatement> getStatementList() {
        return statementList;
    }

    public void setStatementList(List<AbstractStatement> statementList) {
        this.statementList = statementList;
    }

    public String getKeywordName() {
        return keywordName;
    }

    public void setKeywordName(String keywordName) {
        this.keywordName = keywordName;
    }

    public List<String> getArgsList() {
        return argsList;
    }

    public void setArgsList(List<String> argsList) {
        this.argsList = argsList;
    }

}
