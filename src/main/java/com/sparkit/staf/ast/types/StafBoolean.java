package com.sparkit.staf.ast.types;

import com.sparkit.staf.ast.StafTypes;
import com.sparkit.staf.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;

public class StafBoolean extends AbstractStafObject {
    public StafBoolean(boolean value) {
        super(value, StafTypes.BOOL);
    }

    @Override
    public Object evaluate(SymbolsTable globalSymTable, SymbolsTable localSymTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Exception {
        return this;
    }
}
