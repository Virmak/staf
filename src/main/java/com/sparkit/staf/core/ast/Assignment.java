package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.KeywordCall;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;

public class Assignment implements IStatement {
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
    public Object execute(SymbolsTable globalSymTable, SymbolsTable localSymTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        if (value instanceof KeywordCall) {
            KeywordCall keywordCall = (KeywordCall) value;
            return (keywordCall.execute(globalSymTable, localSymTable, keywordLibrariesRepository));
        }
        return (value);
    }
}
