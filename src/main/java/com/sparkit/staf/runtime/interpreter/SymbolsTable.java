package com.sparkit.staf.runtime.interpreter;

import com.sparkit.staf.ast.Assignment;
import com.sparkit.staf.runtime.interpreter.exceptions.UndefinedVariableException;
import com.sparkit.staf.runtime.interpreter.exceptions.VariableAlreadyDefinedException;
import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;

import java.util.HashMap;
import java.util.Map;

public class SymbolsTable {
    private Map<String, Object> symbolsMap;

    public SymbolsTable(Map<String, Assignment> assignmentMap) {
        symbolsMap = new HashMap<>();
        if (assignmentMap != null) {
            assignmentMap.forEach((k, v) -> symbolsMap.put(k, v.getValue()));
        }
    }

    public SymbolsTable() {
        symbolsMap = new HashMap<>();
    }

    public void addVariablesMap(Map<String, Assignment> assignmentMap,
                                KeywordLibrariesRepository keywordLibrariesRepository) throws Exception {
        for (Map.Entry<String, Assignment> assignmentEntry : assignmentMap.entrySet()) {
            if (symbolsMap.containsKey(assignmentEntry.getKey())) {
                throw new VariableAlreadyDefinedException(assignmentEntry.getKey());
            }
            symbolsMap.put(assignmentEntry.getKey(), assignmentEntry.getValue().execute(this, null, keywordLibrariesRepository));
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
