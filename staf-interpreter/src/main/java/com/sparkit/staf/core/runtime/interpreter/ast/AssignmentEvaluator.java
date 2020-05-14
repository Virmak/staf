package com.sparkit.staf.core.runtime.interpreter.ast;

import com.sparkit.staf.core.ast.Assignment;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AssignmentEvaluator implements INodeEvaluator<Assignment> {
    @Autowired
    private KeywordLibrariesRepository keywordLibrariesRepository;

    @Override
    public AbstractStafObject evaluate(Assignment node, SymbolsTable globalSymTable, SymbolsTable localSymTable) {
        return null;
    }
}
