package com.sparkit.staf.runtime.interpreter;

import com.sparkit.staf.ast.Assignment;
import com.sparkit.staf.ast.StafObject;

import java.util.HashMap;
import java.util.Map;

public class SymbolsTable {
    private Map<String, Object> symbolsMap;

    public SymbolsTable(Map<String, Assignment> assignmentMap) {
        symbolsMap = new HashMap<>();
        assignmentMap.forEach((k, v) -> symbolsMap.put(k, v.getValue()));
    }

    public SymbolsTable() {
        symbolsMap = new HashMap<>();
    }

    public Object getSymbolValue(String symbol) {
        return symbolsMap.get(symbol);
    }

    public void setSymbolValue(String symbolName, Object value) {
        symbolsMap.put(symbolName, value);
    }

    public Map<String, Object> getSymbolsMap() {
        return symbolsMap;
    }
}
