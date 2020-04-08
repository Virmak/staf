package com.sparkit.staf.core.runtime.factory;

import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.runtime.interpreter.*;
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
    private StatementBlockExecutor statementBlockExecutor;
    @Autowired
    private IStafConfig config;

    @Override
    public IStafScriptInterpreter getScriptInterpreter(StafFile scriptAST,  String filePath, String currentDirectory,
                                                       String testSuiteName, String testDirectory) {
        SymbolsTable globalSymTable = new SymbolsTable(statementBlockExecutor);
        KeywordLibrariesRepository keywordsRepository =
                keywordsRepositoryFactory.getKeywordLibrariesRepository(statementBlockExecutor, globalSymTable, scriptAST.getKeywordDeclarationMap());
        IImportsInterpreter importsInterpreter =
                importsInterpreterFactory.getImportsInterpreter(scriptAST, globalSymTable, keywordsRepository, testDirectory);
        return new StafScriptInterpreter(importsInterpreter, config, scriptAST, globalSymTable, keywordsRepository,
                currentDirectory, filePath, testSuiteName, statementBlockExecutor);
    }
}
