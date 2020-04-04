package com.sparkit.staf.core.runtime.factory;

import com.sparkit.staf.core.ast.KeywordDeclaration;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;

import java.util.Map;

public interface IKeywordLibrariesRepositoryFactory {
    KeywordLibrariesRepository getKeywordLibrariesRepository(SymbolsTable globalSymTable, Map<String, KeywordDeclaration> keywordDeclarationMap);
}
