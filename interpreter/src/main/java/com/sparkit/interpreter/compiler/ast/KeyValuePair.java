package com.sparkit.interpreter.compiler.ast;


import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;

public class KeyValuePair {
    protected String key;
    protected AbstractStafObject value;

    public KeyValuePair() {
    }

    public KeyValuePair(String key, AbstractStafObject value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public AbstractStafObject getValue() {
        return value;
    }

    public void setValue(AbstractStafObject value) {
        this.value = value;
    }
}
