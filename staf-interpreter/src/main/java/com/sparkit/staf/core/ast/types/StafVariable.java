package com.sparkit.staf.core.ast.types;

import com.sparkit.staf.core.ast.StafTypes;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.interpreter.exceptions.UndefinedVariableException;

public class StafVariable extends AbstractStafObject {
    public StafVariable(Object value) {
        super(value, StafTypes.VAR_REF);
    }

    @Override
    public Object evaluate(SymbolsTable globalSymbolsTable, SymbolsTable localSymbolsTable) throws Throwable {
        Object obj = null;
        if (localSymbolsTable != null) {
            obj = localSymbolsTable.getSymbolValue(value.toString());
        }
        if (obj == null) {
            obj = globalSymbolsTable.getSymbolValue(value.toString());
        }
        if (obj instanceof StafVariable) {
            AbstractStafObject stafObject = (AbstractStafObject) obj;
            return stafObject.evaluate(globalSymbolsTable, localSymbolsTable);
        } else if (obj == null) {
            throw new UndefinedVariableException(value.toString());
        }
        return obj;
    }
}
