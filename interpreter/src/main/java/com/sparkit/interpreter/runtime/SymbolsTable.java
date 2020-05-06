package com.sparkit.interpreter.runtime;


import com.sparkit.interpreter.compiler.ast.statement.Assignment;
import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.runtime.evaluator.statement.IStatementExecutor;
import com.sparkit.interpreter.runtime.exceptions.UndefinedVariableException;
import com.sparkit.interpreter.runtime.exceptions.VariableAlreadyDefinedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("globalSymTable")
public class SymbolsTable {
    @Autowired
    private IStatementExecutor<Assignment, AbstractStafObject> assignmentExecutor;
    private Map<String, AbstractStafObject> symbolsMap;

    public SymbolsTable() {
        symbolsMap = new HashMap<>();
    }

    public void addVariablesMap(Map<String, Assignment> assignmentMap) throws Throwable {
        for (Map.Entry<String, Assignment> assignmentEntry : assignmentMap.entrySet()) {
            if (symbolsMap.containsKey(assignmentEntry.getKey())) {
                throw new VariableAlreadyDefinedException(assignmentEntry.getKey());
            }
            symbolsMap.put(assignmentEntry.getKey(),
                    assignmentExecutor.execute(assignmentEntry.getValue(), null));
        }
    }

    public AbstractStafObject getSymbolValue(String symbol) throws UndefinedVariableException {
        return symbolsMap.get(symbol);
    }

    public void setSymbolValue(String symbolName, AbstractStafObject value) {
        symbolsMap.put(symbolName, value);
    }

    public Map<String, AbstractStafObject> getSymbolsMap() {
        return symbolsMap;
    }

    public void init() {
        symbolsMap = new HashMap<>();
    }
}
