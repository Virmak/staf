package com.sparkit.interpreter.compiler.ast.statement;

import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.compiler.ast.types.StafVariable;

import java.util.List;

public class ForStatement implements IStatement {
    private StafVariable var;
    private AbstractStafObject iterator;
    private List<IStatement> statementList;

    public ForStatement() {
    }

    public ForStatement(StafVariable var, AbstractStafObject iterator, List<IStatement> statementList) {
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

    public AbstractStafObject getIterator() {
        return iterator;
    }

    public void setIterator(AbstractStafObject iterator) {
        this.iterator = iterator;
    }

    public List<IStatement> getStatementList() {
        return statementList;
    }

    public void setStatementList(List<IStatement> statementList) {
        this.statementList = statementList;
    }


}
