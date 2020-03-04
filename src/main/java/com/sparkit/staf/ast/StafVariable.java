package com.sparkit.staf.ast;

import com.sparkit.staf.ast.types.AbstractStafObject;

public class StafVariable {
    protected String varName;
    protected AbstractStafObject value;

    public StafVariable(String varName, AbstractStafObject value) {
        this.varName = varName;
        this.value = value;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    public AbstractStafObject getValue() {
        return value;
    }

    public void setValue(AbstractStafObject value) {
        this.value = value;
    }
}
