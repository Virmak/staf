package com.sparkit.staf.ast;

import com.sparkit.staf.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;

public interface IStatement {
    Object execute(SymbolsTable globalSymTable, SymbolsTable symTable,
                   KeywordLibrariesRepository libraryKeywordsRepository) throws Exception;
}
