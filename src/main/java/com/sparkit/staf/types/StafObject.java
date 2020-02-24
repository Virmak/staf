package com.sparkit.staf.types;

public class StafObject {
    protected Object value;

    public StafObject() {
    }

    public StafObject(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
