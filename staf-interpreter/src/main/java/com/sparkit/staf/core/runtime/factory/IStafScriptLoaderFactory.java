package com.sparkit.staf.core.runtime.factory;

import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.loader.IStafScriptLoader;

public interface IStafScriptLoaderFactory {
    IStafScriptLoader getScriptLoader(SymbolsTable globalSymTable, StafFile scriptAST, KeywordLibrariesRepository keywordLibrariesRepository);
}
