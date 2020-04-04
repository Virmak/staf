package com.sparkit.staf.core.runtime.factory;

import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.runtime.loader.StafScriptLoader;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.loader.IStafCompiler;
import com.sparkit.staf.core.runtime.loader.IStafScriptLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StafScriptLoaderFactory implements IStafScriptLoaderFactory {
    @Autowired
    private IStafCompiler compiler;

    @Override
    public IStafScriptLoader getScriptLoader(SymbolsTable globalSymTable, StafFile scriptAST, KeywordLibrariesRepository keywordLibrariesRepository) {
        return new StafScriptLoader(compiler, globalSymTable, keywordLibrariesRepository);
    }
}
