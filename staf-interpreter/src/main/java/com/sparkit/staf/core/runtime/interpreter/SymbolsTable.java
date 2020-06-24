package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.Assignment;
import com.sparkit.staf.core.ast.types.StafInteger;
import com.sparkit.staf.core.runtime.interpreter.exceptions.UndefinedVariableException;
import com.sparkit.staf.core.runtime.interpreter.exceptions.VariableAlreadyDefinedException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("sharedGlobalSymbolsTable")
public class SymbolsTable {
    private final Map<String, Object> symbolsMap;

    public SymbolsTable() {
        symbolsMap = new HashMap<>();
    }

    public SymbolsTable(Map<String, Object> symbolsMap) {
        this.symbolsMap = symbolsMap;
    }

    public void addVariablesMap(Map<String, Assignment> assignmentMap) throws Throwable {
        for (Map.Entry<String, Assignment> assignmentEntry : assignmentMap.entrySet()) {
            if (symbolsMap.containsKey(assignmentEntry.getKey())) {
                throw new VariableAlreadyDefinedException(assignmentEntry.getKey());
            }
            symbolsMap.put(assignmentEntry.getKey(), assignmentEntry.getValue().execute(this, null));
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

    public void clearSymbolsMap() {
        symbolsMap.clear();
    }

    public int getSessionId() {
        StafInteger session = (StafInteger) this.symbolsMap.get("$__session__");
        return (int)session.getValue();
    }
}
