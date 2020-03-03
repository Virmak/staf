package com.sparkit.staf.ast;

import com.sparkit.staf.runtime.interpreter.exceptions.UndefinedVariableException;
import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.runtime.interpreter.exceptions.UndefinedKeywordException;

import java.util.List;

public class KeywordCall extends StafObject implements IStatement{
    protected String keywordName;
    protected List<StafObject> argumentsList;

    public KeywordCall(String keywordName, List<StafObject> argumentsList) {
        this.keywordName = keywordName;
        this.argumentsList = argumentsList;
    }

    public KeywordCall() {
    }

    public String getKeywordName() {
        return keywordName;
    }

    public void setKeywordName(String keywordName) {
        this.keywordName = keywordName;
    }

    public List<StafObject> getArgumentsList() {
        return argumentsList;
    }

    public void setArgumentsList(List<StafObject> argumentsList) {
        this.argumentsList = argumentsList;
    }

    public Object[] evaluateArgumentsList(SymbolsTable globalSymTable, SymbolsTable localSymTable,
                                              KeywordLibrariesRepository keywordLibrariesRepository) throws Exception {
        Object[] params = new StafObject[argumentsList.size()];
        int i = 0;
        for (StafObject arg : argumentsList) {
            if (arg.getType() == StafTypes.VAR_REF) {
                StafObject symbolValue = null;
                if (localSymTable != null) {
                    symbolValue = (StafObject) localSymTable.getSymbolValue(arg.getValue().toString());
                }
                if (symbolValue == null) {
                    symbolValue = (StafObject) globalSymTable.getSymbolValue(arg.getValue().toString());
                }
                if (symbolValue == null) {
                    throw new UndefinedVariableException(arg.getValue().toString());
                } else {
                    params[i++] = symbolValue;
                }
            } else if (arg.getType() == StafTypes.KEYWORD_CALL) {
                KeywordCall keywordCall = (KeywordCall)arg;
                params[i++] = (StafObject)keywordCall.execute(globalSymTable, localSymTable, keywordLibrariesRepository);
            } else {
                params[i++] = arg;
            }
        }
        return params;
    }

    @Override
    public Object execute(SymbolsTable globalSymTable, SymbolsTable localSymTable,
                          KeywordLibrariesRepository keywordLibrariesRepository) throws Exception {
        if (keywordLibrariesRepository.isKeywordDeclared(keywordName)) {
            return keywordLibrariesRepository.invokeKeyword(keywordName, evaluateArgumentsList(globalSymTable,
                    localSymTable, keywordLibrariesRepository));
        } else {
            throw new UndefinedKeywordException(keywordName);
        }
    }
}
