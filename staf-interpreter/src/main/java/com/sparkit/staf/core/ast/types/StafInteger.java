package com.sparkit.staf.core.ast.types;

import com.sparkit.staf.core.ast.StafTypes;
import com.sparkit.staf.core.runtime.interpreter.MemoryMap;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;

public class StafInteger extends AbstractStafObject {
    public StafInteger(int value) {
        super(value, StafTypes.INT);
    }

    @Override
    public Object evaluate(MemoryMap globalSymbolsTable, MemoryMap localSymbolsTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Exception {
        return this;
    }

}
