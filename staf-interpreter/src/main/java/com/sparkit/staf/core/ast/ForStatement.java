package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.StafList;
import com.sparkit.staf.core.ast.types.StafVariable;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;

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

    @Override
    public Object execute(SymbolsTable globalSymTable, SymbolsTable localSymTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        AbstractStafObject tmp = null;  // used to save variable with the same name as the loop variable if it currently
                                        // exist in localSymTable so we can retrieve it later after for statement execution
        if (localSymTable == null) {
            localSymTable = new SymbolsTable();
        } else {
            tmp = (AbstractStafObject) localSymTable.getSymbolValue(var.getValue().toString());
        }
        AbstractStafObject actualIterator = (AbstractStafObject) iterator.evaluate(globalSymTable, localSymTable, keywordLibrariesRepository);
        if (actualIterator instanceof StafList) {
            for (AbstractStafObject item : ((StafList)actualIterator).getList()) {
                for (IStatement statement : statementList) {
                    localSymTable.setSymbolValue(var.getValue().toString(), item);
                    statement.execute(globalSymTable, localSymTable, keywordLibrariesRepository);
                }
            }
        }

        if (tmp != null) { // if variable with same name exist put it in symTable
            localSymTable.setSymbolValue(var.getValue().toString(), tmp);
        } else { // remove it from localSymTable
            localSymTable.getSymbolsMap().remove(var.getValue().toString());
        }
        return null;
    }
}
