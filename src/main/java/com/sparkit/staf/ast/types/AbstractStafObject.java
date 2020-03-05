package com.sparkit.staf.ast.types;

import com.sparkit.staf.ast.StafTypes;
import com.sparkit.staf.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;

public abstract class AbstractStafObject {
    protected Object value;
    protected StafTypes type;

    public AbstractStafObject() {
    }

    public AbstractStafObject(Object value, StafTypes type) {
        this.value = value;
        this.type = type;
    }

    public StafTypes getType() {
        return type;
    }

    public void setType(StafTypes type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean isPrimitive() {
        return this.type == StafTypes.BOOL
                || this.type == StafTypes.INT
                || this.type == StafTypes.DOUBLE
                || this.type == StafTypes.STRING;
    }

    public abstract Object evaluate(SymbolsTable globalSymTable, SymbolsTable localSymTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Exception;

}
