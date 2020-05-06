package com.sparkit.interpreter.runtime.evaluator;

import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.compiler.ast.types.ListItemAccess;
import com.sparkit.interpreter.runtime.SymbolsTable;
import org.springframework.stereotype.Component;

@Component
public class ListItemAccessEvaluator implements IStafObjectEvaluator<ListItemAccess> {
    @Override
    public AbstractStafObject evaluate(ListItemAccess object, SymbolsTable localSymTable) throws Exception {
        throw new Exception("not implemented");
    }
}
