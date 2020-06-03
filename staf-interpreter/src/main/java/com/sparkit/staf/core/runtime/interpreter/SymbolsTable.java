package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.Assignment;
import com.sparkit.staf.core.runtime.interpreter.exceptions.UndefinedVariableException;
import com.sparkit.staf.core.runtime.interpreter.exceptions.VariableAlreadyDefinedException;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

@Component("globalSymTable")
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SymbolsTable {
    private final Map<String, Object> symbolsMap;

    public SymbolsTable() {
        symbolsMap = new HashMap<>();
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
}
