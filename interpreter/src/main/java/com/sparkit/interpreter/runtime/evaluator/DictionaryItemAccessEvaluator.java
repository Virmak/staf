package com.sparkit.interpreter.runtime.evaluator;

import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.compiler.ast.types.DictionaryItemAccess;
import com.sparkit.interpreter.runtime.SymbolsTable;
import org.springframework.stereotype.Component;

@Component
public class DictionaryItemAccessEvaluator implements IStafObjectEvaluator<DictionaryItemAccess> {
    @Override
    public AbstractStafObject evaluate(DictionaryItemAccess object, SymbolsTable localSymTable) throws Exception {
        throw new Exception("not implemented");
    }
}
