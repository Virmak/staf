package com.sparkit.staf.core.runtime.interpreter.ast;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.KeywordCall;
import com.sparkit.staf.core.runtime.interpreter.StatementBlockExecutor;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.interpreter.exceptions.UndefinedKeywordException;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KeywordCallEvaluator implements INodeEvaluator<KeywordCall> {
    @Autowired
    private KeywordLibrariesRepository keywordLibrariesRepository;
    @Autowired
    private StatementBlockExecutor blockExecutor;

    @Override
    public AbstractStafObject evaluate(KeywordCall keywordCall, SymbolsTable globalSymbolsTable, SymbolsTable localSymTable)
            throws Throwable {
        blockExecutor.getCallStack().push(keywordCall);
        if (keywordLibrariesRepository.isKeywordDeclared(keywordCall.getKeywordName())) {
            Object[] params = keywordCall.evaluateArgumentsList(globalSymbolsTable, localSymTable);
            return (AbstractStafObject) keywordLibrariesRepository.invokeKeyword(globalSymbolsTable, keywordCall.getKeywordName(), params);
        } else {
            throw new UndefinedKeywordException(keywordCall.getKeywordName());
        }
    }
}
