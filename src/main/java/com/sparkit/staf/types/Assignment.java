package com.sparkit.staf.types;

public class Assignment extends AbstractStatement {
    protected StafObject object;
    protected StafObject value;

    public Assignment(StafObject object, StafObject value) {
        this.object = object;
        this.value = value;
    }

    public Assignment() {
    }

    public StafObject getObject() {
        return object;
    }

    public void setObject(StafObject object) {
        this.object = object;
    }

    public StafObject getValue() {
        return value;
    }

    public void setValue(StafObject value) {
        this.value = value;
    }
}
