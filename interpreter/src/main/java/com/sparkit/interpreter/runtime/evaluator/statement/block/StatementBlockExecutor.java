package com.sparkit.interpreter.runtime.evaluator.statement.block;

import com.sparkit.interpreter.compiler.ast.statement.StafCallable;
import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.runtime.SymbolsTable;
import org.springframework.stereotype.Component;

@Component
public class StatementBlockExecutor implements IStatementBlockExecutor<StafCallable> {
    @Override
    public AbstractStafObject execute(StafCallable statementBlock, SymbolsTable parentLocalSymTable) {
        return null;
    }
}
