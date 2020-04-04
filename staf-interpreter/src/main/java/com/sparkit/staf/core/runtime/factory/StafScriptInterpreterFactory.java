package com.sparkit.staf.core.runtime.factory;

import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.runtime.interpreter.IImportsInterpreter;
import com.sparkit.staf.core.runtime.interpreter.IStafScriptInterpreter;
import com.sparkit.staf.core.runtime.interpreter.StafScriptInterpreter;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.loader.IStafConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StafScriptInterpreterFactory implements IStafScriptInterpreterFactory {
    @Autowired
    private IKeywordLibrariesRepositoryFactory keywordsRepositoryFactory;
    @Autowired
    private IImportsInterpreterFactory importsInterpreterFactory;
    @Autowired
    private IStafConfig config;

    @Override
    public IStafScriptInterpreter getScriptInterpreter(StafFile scriptAST, String filePath, String currentDirectory,
                                                       String testSuiteName, String testDirectory) {
        SymbolsTable globalSymTable = new SymbolsTable();
        KeywordLibrariesRepository keywordsRepository =
                keywordsRepositoryFactory.getKeywordLibrariesRepository(globalSymTable, scriptAST.getKeywordDeclarationMap());
        IImportsInterpreter importsInterpreter =
                importsInterpreterFactory.getImportsInterpreter(scriptAST, globalSymTable, keywordsRepository, testDirectory);
        return new StafScriptInterpreter(importsInterpreter, config, scriptAST, globalSymTable, keywordsRepository, currentDirectory, filePath, testSuiteName);
    }
}
