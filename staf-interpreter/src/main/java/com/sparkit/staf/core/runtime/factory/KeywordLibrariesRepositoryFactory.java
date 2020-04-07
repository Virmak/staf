package com.sparkit.staf.core.runtime.factory;

import com.sparkit.staf.core.ast.KeywordDeclaration;
import com.sparkit.staf.core.runtime.interpreter.StatementBlockExecutor;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.loader.TestContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class KeywordLibrariesRepositoryFactory implements IKeywordLibrariesRepositoryFactory {
    @Autowired
    private TestContainer testContainer;

    @Override
    public KeywordLibrariesRepository getKeywordLibrariesRepository(StatementBlockExecutor statementBlockExecutor, SymbolsTable globalSymTable, Map<String, KeywordDeclaration> keywordDeclarationMap) {
        return new KeywordLibrariesRepository(keywordDeclarationMap, globalSymTable, statementBlockExecutor, testContainer);
    }
}
