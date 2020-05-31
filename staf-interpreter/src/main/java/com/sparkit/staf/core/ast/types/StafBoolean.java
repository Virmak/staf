package com.sparkit.staf.core.ast.types;

import com.sparkit.staf.core.ast.StafTypes;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;

public class StafBoolean extends AbstractStafObject {
    public StafBoolean(boolean value) {
        super(value, StafTypes.BOOL);
    }

    @Override
    public Object evaluate(SymbolsTable globalSymbolsTable, SymbolsTable localSymbolsTable) throws Exception {
        return this;
    }
}
