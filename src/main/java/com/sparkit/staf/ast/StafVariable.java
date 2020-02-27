package com.sparkit.staf.ast;

public class StafVariable {
    protected String varName;
    protected StafObject value;

    public StafVariable(String varName, StafObject value) {
        this.varName = varName;
        this.value = value;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    public StafObject getValue() {
        return value;
    }

    public void setValue(StafObject value) {
        this.value = value;
    }
}
