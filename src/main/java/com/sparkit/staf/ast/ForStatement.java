package com.sparkit.staf.ast;

import com.sparkit.staf.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;

import java.util.List;

public class ForStatement implements IStatement {
    private StafVariable var;
    private StafObject iterator;
    private List<IStatement> statementList;

    public ForStatement() {
    }

    public ForStatement(StafVariable var, StafObject iterator, List<IStatement> statementList) {
        this.var = var;
        this.iterator = iterator;
        this.statementList = statementList;
    }

    public StafVariable getVar() {
        return var;
    }

    public void setVar(StafVariable var) {
        this.var = var;
    }

    public StafObject getIterator() {
        return iterator;
    }

    public void setIterator(StafObject iterator) {
        this.iterator = iterator;
    }

    public List<IStatement> getStatementList() {
        return statementList;
    }

    public void setStatementList(List<IStatement> statementList) {
        this.statementList = statementList;
    }

    @Override
    public Object execute(SymbolsTable globalSymTable, SymbolsTable symTable, KeywordLibrariesRepository libraryKeywordsRepository) throws Exception {
        throw new Exception("not implemented");
    }
}
