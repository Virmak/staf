package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.Assignment;
import com.sparkit.staf.core.ast.types.StafInteger;
import com.sparkit.staf.core.runtime.interpreter.exceptions.VariableAlreadyDefinedException;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;

import java.util.HashMap;
import java.util.Map;

public class MemoryMap {
    private final Map<String, Object> variablesMap;

    public MemoryMap() {
        variablesMap = new HashMap<>();
    }

    public MemoryMap(Map<String, Object> variablesMap) {
        this.variablesMap = variablesMap;
    }

    public void addVariablesMap(Map<String, Assignment> assignmentMap, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        for (Map.Entry<String, Assignment> assignmentEntry : assignmentMap.entrySet()) {
            if (variablesMap.containsKey(assignmentEntry.getKey())) {
                throw new VariableAlreadyDefinedException(assignmentEntry.getKey());
            }
            variablesMap.put(assignmentEntry.getKey(),
                    assignmentEntry.getValue().execute(this, null, keywordLibrariesRepository));
        }
    }

    public Object getVariableValue(String symbol) {
        return variablesMap.get(symbol);
    }

    public void setVariableValue(String symbolName, Object value) {
        variablesMap.put(symbolName, value);
    }

    public Map<String, Object> getVariablesMap() {
        return variablesMap;
    }

    public void clearSymbolsMap() {
        variablesMap.clear();
    }

    public int getSessionId() {
        StafInteger session = (StafInteger) this.variablesMap.get("$__session__");
        if (session != null) {
            return (int) session.getValue();
        } else {
            return -1; // if $__session__ is null => still in VARS section initializing global shared symbols table
        }
    }
}
