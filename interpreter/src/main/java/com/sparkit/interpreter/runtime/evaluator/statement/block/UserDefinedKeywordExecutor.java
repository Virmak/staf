package com.sparkit.interpreter.runtime.evaluator.statement.block;

import com.sparkit.interpreter.compiler.ast.KeywordDeclaration;
import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.runtime.SymbolsTable;
import org.springframework.stereotype.Component;

@Component
public class UserDefinedKeywordExecutor implements IStatementBlockExecutor<KeywordDeclaration> {
    @Override
    public AbstractStafObject execute(KeywordDeclaration statementBlock, SymbolsTable parentLocalSymTable) {
        return null;
    }
}
