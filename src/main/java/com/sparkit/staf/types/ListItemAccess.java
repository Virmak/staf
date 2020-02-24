package com.sparkit.staf.types;

public class ListItemAccess extends StafObject {
    protected StafList list;
    protected int index;

    public ListItemAccess(StafList list, int index) {
        this.list = list;
        this.index = index;
    }
}
