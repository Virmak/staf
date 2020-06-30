package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;

public interface IStatement {
    Object execute(SymbolsTable globalSymbolsTable, SymbolsTable localSymbolsTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable;
}
