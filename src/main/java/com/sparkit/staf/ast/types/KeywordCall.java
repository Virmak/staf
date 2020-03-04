package com.sparkit.staf.ast.types;

import com.sparkit.staf.ast.IStatement;

import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.runtime.interpreter.exceptions.UndefinedKeywordException;

import java.util.List;

public class KeywordCall extends AbstractStafObject implements IStatement {
    protected String keywordName;
    protected List<AbstractStafObject> argumentsList;

    public KeywordCall(String keywordName, List<AbstractStafObject> argumentsList) {
        this.keywordName = keywordName;
        this.argumentsList = argumentsList;
    }

    public KeywordCall() {
    }

    @Override
    public Object evaluate(SymbolsTable globalSymTable, SymbolsTable localSymTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Exception {
        throw new Exception("Not implemented");
    }

    public String getKeywordName() {
        return keywordName;
    }

    public void setKeywordName(String keywordName) {
        this.keywordName = keywordName;
    }

    public List<AbstractStafObject> getArgumentsList() {
        return argumentsList;
    }

    public void setArgumentsList(List<AbstractStafObject> argumentsList) {
        this.argumentsList = argumentsList;
    }

    public Object[] evaluateArgumentsList(SymbolsTable globalSymTable, SymbolsTable localSymTable,
                                          KeywordLibrariesRepository keywordLibrariesRepository) throws Exception {
        Object[] params = new AbstractStafObject[argumentsList.size()];
        int i = 0;
        for (AbstractStafObject arg : argumentsList) {
            params[i++] = arg.evaluate(globalSymTable, localSymTable, keywordLibrariesRepository);
        }
        return params;
    }

    @Override
    public Object execute(SymbolsTable globalSymTable, SymbolsTable localSymTable,
                          KeywordLibrariesRepository keywordLibrariesRepository) throws Exception {
        if (keywordLibrariesRepository.isKeywordDeclared(keywordName)) {
            Object[] params = evaluateArgumentsList(globalSymTable,
                    localSymTable, keywordLibrariesRepository);
            return keywordLibrariesRepository.invokeKeyword(keywordName, params);
        } else {
            throw new UndefinedKeywordException(keywordName);
        }
    }
}
