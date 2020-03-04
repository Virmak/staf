package com.sparkit.staf.ast.types;

import com.sparkit.staf.ast.StafTypes;
import com.sparkit.staf.ast.types.AbstractStafObject;
import com.sparkit.staf.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;

public class ListItemAccess extends AbstractStafObject {
    protected AbstractStafObject listVariable;
    protected AbstractStafObject indexObject;

    public ListItemAccess(AbstractStafObject listVariable, AbstractStafObject indexObject) {
        this.listVariable = listVariable;
        this.indexObject = indexObject;
        this.type = StafTypes.LIST_ITEM_REF;
    }

    public AbstractStafObject getListVariable() {
        return listVariable;
    }

    public void setListVariable(AbstractStafObject listVariable) {
        this.listVariable = listVariable;
    }

    public AbstractStafObject getIndexObject() {
        return indexObject;
    }

    public void setIndexObject(AbstractStafObject indexObject) {
        this.indexObject = indexObject;
    }

    @Override
    public Object evaluate(SymbolsTable globalSymTable, SymbolsTable localSymTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Exception {
        throw new Exception("not implemented");
    }
}
