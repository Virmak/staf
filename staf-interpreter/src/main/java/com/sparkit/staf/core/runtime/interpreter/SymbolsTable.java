package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.Assignment;
import com.sparkit.staf.core.runtime.interpreter.exceptions.UndefinedVariableException;
import com.sparkit.staf.core.runtime.interpreter.exceptions.VariableAlreadyDefinedException;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;

import java.util.HashMap;
import java.util.Map;

public class SymbolsTable {
    private StatementBlockExecutor statementBlockExecutor;
    private Map<String, Object> symbolsMap;
    private StatementBlockExecutor blockExecutor;

    public SymbolsTable(StatementBlockExecutor statementBlockExecutor, Map<String, Assignment> assignmentMap) {
        this.statementBlockExecutor = statementBlockExecutor;
        symbolsMap = new HashMap<>();
        if (assignmentMap != null) {
            assignmentMap.forEach((k, v) -> symbolsMap.put(k, v.getValue()));
        }
    }

    public SymbolsTable(StatementBlockExecutor statementBlockExecutor) {
        this.statementBlockExecutor = statementBlockExecutor;
        symbolsMap = new HashMap<>();
    }

    public void addVariablesMap(Map<String, Assignment> assignmentMap,
                                KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        for (Map.Entry<String, Assignment> assignmentEntry : assignmentMap.entrySet()) {
            if (symbolsMap.containsKey(assignmentEntry.getKey())) {
                throw new VariableAlreadyDefinedException(assignmentEntry.getKey());
            }
            symbolsMap.put(assignmentEntry.getKey(), assignmentEntry.getValue().execute(blockExecutor,
                    this, null, keywordLibrariesRepository));
        }
    }

    public Object getSymbolValue(String symbol) throws UndefinedVariableException {
        return symbolsMap.get(symbol);
    }

    public void setSymbolValue(String symbolName, Object value) {
        symbolsMap.put(symbolName, value);
    }

    public Map<String, Object> getSymbolsMap() {
        return symbolsMap;
    }
}
