package com.sparkit.staf.core.ast.types;

import com.sparkit.staf.core.ast.StafTypes;
import com.sparkit.staf.core.runtime.interpreter.MemoryMap;
import com.sparkit.staf.core.runtime.interpreter.exceptions.UndefinedVariableException;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;

public class StafVariable extends AbstractStafObject {
    public StafVariable(Object value) {
        super(value, StafTypes.VAR_REF);
    }

    @Override
    public Object evaluate(MemoryMap globalSymbolsTable, MemoryMap localSymbolsTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        Object obj = null;
        if (localSymbolsTable != null) {
            obj = localSymbolsTable.getVariableValue(value.toString());
        }
        if (obj == null) {
            obj = globalSymbolsTable.getVariableValue(value.toString());
        }
        if (obj instanceof StafVariable) {
            AbstractStafObject stafObject = (AbstractStafObject) obj;
            return stafObject.evaluate(globalSymbolsTable, localSymbolsTable, keywordLibrariesRepository);
        } else if (obj == null) {
            throw new UndefinedVariableException(value.toString());
        }
        return obj;
    }
}
