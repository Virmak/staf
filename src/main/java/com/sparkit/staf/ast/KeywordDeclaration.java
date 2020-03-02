package com.sparkit.staf.ast;

import com.sparkit.staf.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.runtime.interpreter.exceptions.InvalidArgsNumberKeywordCallException;
import com.sparkit.staf.runtime.interpreter.exceptions.UndefinedKeywordException;
import com.sparkit.staf.runtime.interpreter.exceptions.UndefinedVariableException;
import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;

import java.util.Arrays;
import java.util.List;

public class KeywordDeclaration {
    protected String keywordName;
    protected List<String> argsList;
    protected List<IStatement> statementList;
    protected StafObject returnObject;

    public KeywordDeclaration(String keywordName, List<String> argsList, List<IStatement> statementList, StafObject returnObject) {
        this.keywordName = keywordName;
        this.argsList = argsList;
        this.statementList = statementList;
        this.returnObject = returnObject;
    }

    public KeywordDeclaration() {
    }

    public StafObject getReturnObject() {
        return returnObject;
    }

    public void setReturnObject(StafObject returnObject) {
        this.returnObject = returnObject;
    }

    public List<IStatement> getStatementList() {
        return statementList;
    }

    public void setStatementList(List<IStatement> statementList) {
        this.statementList = statementList;
    }

    public String getKeywordName() {
        return keywordName;
    }

    public void setKeywordName(String keywordName) {
        this.keywordName = keywordName;
    }

    public List<String> getArgsList() {
        return argsList;
    }

    public void setArgsList(List<String> argsList) {
        this.argsList = argsList;
    }

    public Object execute(SymbolsTable globalSymTable, KeywordLibrariesRepository keywordLibrariesRepository,
                          Object[] params) throws Exception {
        SymbolsTable localSymTable = new SymbolsTable();
        if (params.length != argsList.size())
            throw new InvalidArgsNumberKeywordCallException(argsList.size(), params.length, keywordName);

        for (int i = 0; i < params.length; i++) {
            localSymTable.setSymbolValue(argsList.get(i), params[i]);
            StafObject stafObject = (StafObject) params[i];
            if (stafObject.getType() == StafTypes.VAR_REF) {
                StafObject valObj = (StafObject) globalSymTable.getSymbolValue(stafObject.getValue().toString());
                if (valObj == null) {
                    throw new UndefinedVariableException(stafObject.getValue().toString());
                }
                localSymTable.setSymbolValue(argsList.get(i), valObj);
            } else if (stafObject.getType() == StafTypes.KEYWORD_CALL) {
                KeywordCall keywordCall = (KeywordCall) stafObject.getValue();
                if (keywordLibrariesRepository.isKeywordDeclared(keywordCall.getKeywordName())) {
                    localSymTable.setSymbolValue(argsList.get(i),
                            keywordLibrariesRepository.invokeKeyword(keywordCall.getKeywordName(), keywordCall.getArgumentsList().toArray()));
                } else {
                    throw new UndefinedKeywordException(keywordCall.getKeywordName());
                }
            }
        }
        for (IStatement statement : statementList) {
            statement.execute(globalSymTable, localSymTable, keywordLibrariesRepository);
        }
        return null;
    }
}
