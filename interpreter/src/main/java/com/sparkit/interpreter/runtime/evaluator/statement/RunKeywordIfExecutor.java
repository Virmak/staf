package com.sparkit.interpreter.runtime.evaluator.statement;

import com.sparkit.interpreter.compiler.ast.RunKeywordIf;
import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.runtime.SymbolsTable;
import com.sparkit.interpreter.runtime.evaluator.StafObjectEvaluator;
import org.springframework.beans.factory.annotation.Autowired;

public class RunKeywordIfExecutor implements IStatementExecutor<RunKeywordIf, AbstractStafObject> {
    @Autowired
    private StafObjectEvaluator objectEvaluator;

    @Override
    public AbstractStafObject execute(RunKeywordIf statement, SymbolsTable localSymbolTable) throws Throwable {
        if ((boolean) objectEvaluator.evaluate(statement.getCondition(), localSymbolTable).getValue()) {
            objectEvaluator.evaluate(statement.getKeywordCall(), localSymbolTable);
        }
        return null;
    }
}
