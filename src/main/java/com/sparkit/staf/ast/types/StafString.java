package com.sparkit.staf.ast.types;

import com.sparkit.staf.ast.StafTypes;
import com.sparkit.staf.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;

public class StafString extends AbstractStafObject {
    public StafString(String value) {
        super(value, StafTypes.STRING);
    }

    @Override
    public Object evaluate(SymbolsTable globalSymTable, SymbolsTable localSymTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Exception {
        return this;
    }
}
