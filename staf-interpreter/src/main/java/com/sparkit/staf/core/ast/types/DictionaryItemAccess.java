package com.sparkit.staf.core.ast.types;

import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;

public class DictionaryItemAccess extends AbstractStafObject {
    protected AbstractStafObject dictVariable;
    protected String itemIdentifier;

    public DictionaryItemAccess(AbstractStafObject dictVariable, String indexObject) {
        this.dictVariable = dictVariable;
        this.itemIdentifier = indexObject;
    }

    public AbstractStafObject getDictVariable() {
        return dictVariable;
    }

    public void setDictVariable(AbstractStafObject dictVariable) {
        this.dictVariable = dictVariable;
    }

    public String getItemIdentifier() {
        return itemIdentifier;
    }

    public void setItemIdentifier(String itemIdentifier) {
        this.itemIdentifier = itemIdentifier;
    }

    @Override
    public Object evaluate(SymbolsTable globalSymbolsTable, SymbolsTable localSymbolsTable) throws Throwable {
        StafDictionary actualDict = (StafDictionary) dictVariable.evaluate(globalSymbolsTable, localSymbolsTable);
        return actualDict.getObjectMap().get(itemIdentifier);
    }
}
