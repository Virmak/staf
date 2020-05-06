package com.sparkit.interpreter.compiler.ast.types;

import com.sparkit.interpreter.compiler.ast.StafTypes;

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

}
