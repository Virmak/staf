package com.sparkit.staf.core.runtime.factory;

import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.runtime.interpreter.IImportsInterpreter;
import com.sparkit.staf.core.runtime.interpreter.ImportsInterpreter;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.loader.IStafScriptLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImportsInterpreterFactory implements IImportsInterpreterFactory {
    @Autowired
    private IStafScriptLoaderFactory scriptLoaderFactory;

    @Override
    public IImportsInterpreter getImportsInterpreter(StafFile scriptAST,
                                                     SymbolsTable globalSymTable,
                                                     KeywordLibrariesRepository keywordLibrariesRepository,
                                                     String testDirectory) {
        IStafScriptLoader scriptLoader = scriptLoaderFactory.getScriptLoader(globalSymTable, scriptAST, keywordLibrariesRepository);
        return new ImportsInterpreter(scriptLoader, keywordLibrariesRepository, testDirectory);
    }
}
