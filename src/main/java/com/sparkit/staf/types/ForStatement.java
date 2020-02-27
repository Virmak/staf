package com.sparkit.staf.types;

import java.util.List;

public class ForStatement extends AbstractStatement {
    private StafVariable var;
    private StafObject iterator;
    private List<AbstractStatement> statementList;

    public ForStatement() {
    }

    public ForStatement(StafVariable var, StafObject iterator, List<AbstractStatement> statementList) {
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

    public List<AbstractStatement> getStatementList() {
        return statementList;
    }

    public void setStatementList(List<AbstractStatement> statementList) {
        this.statementList = statementList;
    }
}
