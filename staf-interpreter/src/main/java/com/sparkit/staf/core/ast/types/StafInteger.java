package com.sparkit.staf.core.ast.types;

import com.sparkit.staf.core.ast.StafTypes;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;

public class StafInteger extends AbstractStafObject {
    public StafInteger(int value) {
        super(value, StafTypes.INT);
    }

    @Override
    public Object evaluate(SymbolsTable globalSymbolsTable, SymbolsTable localSymbolsTable) throws Exception {
        return this;
    }

}
