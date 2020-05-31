package com.sparkit.staf.core.ast.types;

import com.sparkit.staf.core.ast.StafTypes;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import org.json.simple.JSONArray;

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

    public static StafList fromJSONArray(JSONArray array) {
        List<AbstractStafObject> list = new ArrayList<>();
        for (Object item : array) {
            list.add(fromObject(item));
        }
        return new StafList(list);
    }

    @Override
    public Object evaluate(SymbolsTable globalSymbolsTable, SymbolsTable localSymbolsTable) throws Exception {
        return this;
    }

    public List<AbstractStafObject> getList() {
        return value;
    }

    public void setList(List<AbstractStafObject> object) {
        this.value = object;
    }

    public List<Object> getEvaluatedList() {
        List<Object> objectList = new ArrayList<>();
        for (AbstractStafObject object : value) {
            objectList.add(object.getValue());
        }
        return objectList;
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

    public JSONArray toJSON() {
        JSONArray array = new JSONArray();
        for (AbstractStafObject stafObject : value) {
            array.add((stafObject).toJSON());
        }
        return array;
    }
}
