package com.sparkit.staf.core.ast.types;

import com.sparkit.staf.core.ast.StafTypes;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;

public class StafVariable extends AbstractStafObject {
    public StafVariable(Object value) {
        super(value, StafTypes.VAR_REF);
    }

    @Override
    public Object evaluate(SymbolsTable globalSymTable, SymbolsTable localSymTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        Object obj = null;
        if (localSymTable != null) {
            obj = localSymTable.getSymbolValue(value.toString());
        }
        if (obj == null) {
            obj = globalSymTable.getSymbolValue(value.toString());
        }
        if (obj instanceof StafVariable) {
            AbstractStafObject stafObject = (AbstractStafObject)obj;
            return stafObject.evaluate(globalSymTable, localSymTable, keywordLibrariesRepository);
        }
        return obj;
    }
}
