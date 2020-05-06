package com.sparkit.interpreter.runtime.evaluator.statement;

import com.sparkit.interpreter.compiler.ast.statement.Assignment;
import com.sparkit.interpreter.compiler.ast.statement.KeywordCall;
import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.runtime.SymbolsTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AssignmentExecutor implements IStatementExecutor<Assignment, AbstractStafObject> {
    @Autowired
    private SymbolsTable globalSymTable;
    @Autowired
    private IStatementExecutor<KeywordCall, AbstractStafObject> keywordCallExecutor;

    @Override
    public AbstractStafObject execute(Assignment statement, SymbolsTable localSymbolTable) throws Throwable {
        AbstractStafObject value = statement.getValue();
        AbstractStafObject object = statement.getObject();
        if (value instanceof KeywordCall) {
            KeywordCall keywordCall = (KeywordCall) value;
            AbstractStafObject returnObject = keywordCallExecutor.execute(keywordCall, localSymbolTable);
            if (localSymbolTable != null && localSymbolTable.getSymbolsMap().containsKey(object.getValue().toString())) {
                localSymbolTable.getSymbolsMap().put(object.getValue().toString(), returnObject);
            } else if (globalSymTable.getSymbolsMap().containsKey(object.getValue().toString())) {
                globalSymTable.getSymbolsMap().put(object.getValue().toString(), returnObject);
            } else if (localSymbolTable != null) {
                localSymbolTable.getSymbolsMap().put(object.getValue().toString(), returnObject);
            }
            return returnObject;
        }
        if (localSymbolTable != null && localSymbolTable.getSymbolsMap().containsKey(object.getValue().toString())) {
            localSymbolTable.getSymbolsMap().put(object.getValue().toString(), value);
        } else if (globalSymTable.getSymbolsMap().containsKey(object.getValue().toString())) {
            globalSymTable.getSymbolsMap().put(object.getValue().toString(), value);
        } else if (localSymbolTable != null) {
            localSymbolTable.getSymbolsMap().put(object.getValue().toString(), value);
        }
        return value;
    }

}
