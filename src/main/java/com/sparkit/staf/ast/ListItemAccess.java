package com.sparkit.staf.ast;

public class ListItemAccess extends StafObject {
    protected StafObject listVariable;
    protected StafObject indexObject;

    public ListItemAccess(StafObject listVariable, StafObject indexObject) {
        this.listVariable = listVariable;
        this.indexObject = indexObject;
        this.type = StafTypes.LIST_ITEM_REF;
    }

    public StafObject getListVariable() {
        return listVariable;
    }

    public void setListVariable(StafObject listVariable) {
        this.listVariable = listVariable;
    }

    public StafObject getIndexObject() {
        return indexObject;
    }

    public void setIndexObject(StafObject indexObject) {
        this.indexObject = indexObject;
    }
}
