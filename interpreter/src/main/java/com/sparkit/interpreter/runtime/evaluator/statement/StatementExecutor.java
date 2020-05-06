package com.sparkit.interpreter.runtime.evaluator.statement;

import com.sparkit.interpreter.compiler.ast.RunKeywordIf;
import com.sparkit.interpreter.compiler.ast.statement.Assignment;
import com.sparkit.interpreter.compiler.ast.statement.ForStatement;
import com.sparkit.interpreter.compiler.ast.statement.IStatement;
import com.sparkit.interpreter.compiler.ast.statement.KeywordCall;
import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.runtime.SymbolsTable;
import org.springframework.beans.factory.annotation.Autowired;

public class StatementExecutor implements IStatementExecutor<IStatement, AbstractStafObject> {
    @Autowired
    private KeywordCallExecutor keywordCallExecutor;
    @Autowired
    private AssignmentExecutor assignmentExecutor;
    @Autowired
    private RunKeywordIfExecutor runKeywordIfExecutor;

    @Override
    public AbstractStafObject execute(IStatement statement, SymbolsTable localSymbolTable) throws Throwable {
        if (statement instanceof RunKeywordIf) {
            runKeywordIfExecutor.execute((RunKeywordIf) statement, localSymbolTable);
        } else if (statement instanceof KeywordCall) {
            keywordCallExecutor.execute((KeywordCall) statement, localSymbolTable);
        } else if (statement instanceof Assignment) {
            assignmentExecutor.execute((Assignment) statement, localSymbolTable);
        } else if (statement instanceof ForStatement) {

        }
        return null;
    }
}
