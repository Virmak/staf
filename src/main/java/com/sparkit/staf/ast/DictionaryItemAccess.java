package com.sparkit.staf.ast;

public class DictionaryItemAccess extends StafObject {
    protected StafObject dictVariable;
    protected String itemIdentifier;

    public DictionaryItemAccess(StafObject dictVariable, String indexObject) {
        this.dictVariable = dictVariable;
        this.itemIdentifier = indexObject;
    }

    public DictionaryItemAccess() {
    }

    public StafObject getDictVariable() {
        return dictVariable;
    }

    public void setDictVariable(StafObject dictVariable) {
        this.dictVariable = dictVariable;
    }

    public String getItemIdentifier() {
        return itemIdentifier;
    }

    public void setItemIdentifier(String itemIdentifier) {
        this.itemIdentifier = itemIdentifier;
    }
}
