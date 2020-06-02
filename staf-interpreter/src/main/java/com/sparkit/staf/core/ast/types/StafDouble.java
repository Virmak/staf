package com.sparkit.staf.core.ast.types;

import com.sparkit.staf.core.ast.StafTypes;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;

public class StafDouble extends AbstractStafObject {
    public StafDouble(double value) {
        super(value, StafTypes.DOUBLE);
    }

    @Override
    public Object evaluate(SymbolsTable globalSymbolsTable, SymbolsTable localSymbolsTable) throws Exception {
        return this;
    }

}
