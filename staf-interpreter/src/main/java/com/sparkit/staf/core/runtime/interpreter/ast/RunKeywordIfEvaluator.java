package com.sparkit.staf.core.runtime.interpreter.ast;

import com.sparkit.staf.core.ast.RunKeywordIf;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RunKeywordIfEvaluator implements INodeEvaluator<RunKeywordIf> {
    @Autowired
    private KeywordLibrariesRepository keywordLibrariesRepository;

    @Override
    public AbstractStafObject evaluate(RunKeywordIf node, SymbolsTable globalSymTable, SymbolsTable localSymTable) {
        return null;
    }
}
