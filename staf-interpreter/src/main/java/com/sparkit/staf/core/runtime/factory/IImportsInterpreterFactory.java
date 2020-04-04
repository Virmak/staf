package com.sparkit.staf.core.runtime.factory;

import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.runtime.interpreter.IImportsInterpreter;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;

public interface IImportsInterpreterFactory {
    IImportsInterpreter getImportsInterpreter(StafFile scriptAST, SymbolsTable globalSymTable,
                                              KeywordLibrariesRepository keywordLibrariesRepository,
                                              String testDirectory);
}
