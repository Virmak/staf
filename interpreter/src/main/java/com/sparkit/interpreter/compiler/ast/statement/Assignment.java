package com.sparkit.interpreter.compiler.ast.statement;

import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;

import java.util.List;

public class Assignment implements IStatement{
    protected AbstractStafObject object;
    protected AbstractStafObject value;

    public Assignment(AbstractStafObject object, AbstractStafObject value) {
        this.object = object;
        this.value = value;
    }

    public Assignment() {
    }

    public AbstractStafObject getObject() {
        return object;
    }

    public void setObject(AbstractStafObject object) {
        this.object = object;
    }

    public AbstractStafObject getValue() {
        return value;
    }

    public void setValue(AbstractStafObject value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Assignment : " + object + " = " + value;
    }
}
