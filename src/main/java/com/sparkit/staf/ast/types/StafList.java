package com.sparkit.staf.ast.types;

import com.sparkit.staf.ast.StafTypes;
import com.sparkit.staf.ast.types.AbstractStafObject;
import com.sparkit.staf.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;

import java.util.ArrayList;
import java.util.List;

public class StafList extends AbstractStafObject {
    protected List<AbstractStafObject> value;

    public StafList() {
        value = new ArrayList<>();
        this.type = StafTypes.LIST;
    }

    public StafList(List<AbstractStafObject> items) {
        this.value = items;
        this.type = StafTypes.LIST;
    }

    @Override
    public Object evaluate(SymbolsTable globalSymTable, SymbolsTable localSymTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Exception {
        return this;
    }

    public List<AbstractStafObject> getList() {
        return value;
    }

    public void setList(List<AbstractStafObject> object) {
        this.value = object;
    }

    public void addListItem(AbstractStafObject item) {
        value.add(item);
    }

    public void setItemAt(int index, AbstractStafObject item) {
        value.set(index, item);
    }

    public void removeItemAt(int index) {
        value.remove(index);
    }

}
