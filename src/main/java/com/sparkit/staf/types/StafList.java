package com.sparkit.staf.types;

import java.util.ArrayList;
import java.util.List;

public class StafList extends StafObject {
    protected List<StafObject> items;

    public StafList() {
        items = new ArrayList<>();
    }

    public StafList(List<StafObject> items) {
        this.items = items;
    }

    public List<StafObject> getItems() {
        return items;
    }

    public void setItems(List<StafObject> items) {
        this.items = items;
    }

    public void addListItem(StafObject item) {
        items.add(item);
    }

    public void setItemAt(int index, StafObject item) {
        items.set(index, item);
    }

    public void removeItemAt(int index) {
        items.remove(index);
    }

}
