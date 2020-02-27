package com.sparkit.staf.ast;

import java.util.ArrayList;
import java.util.List;

public class StafList extends StafObject {
    protected List<StafObject> value;

    public StafList() {
        value = new ArrayList<>();
        this.type = StafTypes.LIST;
    }

    public StafList(List<StafObject> items) {
        this.value = items;
        this.type = StafTypes.LIST;
    }

    public List<StafObject> getList() {
        return value;
    }

    public void setList(List<StafObject> object) {
        this.value = object;
    }

    public void addListItem(StafObject item) {
        value.add(item);
    }

    public void setItemAt(int index, StafObject item) {
        value.set(index, item);
    }

    public void removeItemAt(int index) {
        value.remove(index);
    }

}
