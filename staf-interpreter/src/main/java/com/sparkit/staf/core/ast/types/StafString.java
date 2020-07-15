package com.sparkit.staf.core.ast.types;

import com.sparkit.staf.core.ast.StafTypes;
import com.sparkit.staf.core.runtime.interpreter.MemoryMap;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;

public class StafString extends AbstractStafObject {
    public StafString(String value) {
        super(value, StafTypes.STRING);
    }

    @Override
    public Object evaluate(MemoryMap globalSymbolsTable,
                           MemoryMap localSymbolsTable, KeywordLibrariesRepository keywordLibrariesRepository) {
        return this;
    }

    @Override
    public String toString() {
        return "\"" + value + "\"";
    }
}
