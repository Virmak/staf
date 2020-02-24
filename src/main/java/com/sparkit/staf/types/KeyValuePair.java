package com.sparkit.staf.types;

public class KeyValuePair {
    protected String key;
    protected StafObject value;

    public KeyValuePair() {
    }

    public KeyValuePair(String key, StafObject value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public StafObject getValue() {
        return value;
    }

    public void setValue(StafObject value) {
        this.value = value;
    }
}
