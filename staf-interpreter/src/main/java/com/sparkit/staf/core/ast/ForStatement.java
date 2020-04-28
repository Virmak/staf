package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.StafList;
import com.sparkit.staf.core.ast.types.StafVariable;
import com.sparkit.staf.core.runtime.interpreter.IStatementBlock;
import com.sparkit.staf.core.runtime.interpreter.IStafIterable;
import com.sparkit.staf.core.runtime.interpreter.StatementBlockExecutor;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.reports.StatementReport;

import java.util.ArrayList;
import java.util.List;

public class ForStatement implements IStatement, IStatementBlock, IStafIterable {
    private StafVariable var;
    private AbstractStafObject iterator;
    private List<IStatement> statementList;
    private List<StatementReport> statementReports;
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
    public Object execute(StatementBlockExecutor blockExecutor, SymbolsTable globalSymTable, SymbolsTable localSymTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        return blockExecutor.executeIterable(this, globalSymTable, localSymTable, keywordLibrariesRepository);
    }

    @Override
    public List<IStatement> getStatements() {
        return statementList;
    }

    @Override
    public List<StatementReport> getStatementReports() {
        return statementReports;
    }

    @Override
    public void setStatementReports(List<StatementReport> reports) {
        this.statementReports = reports;
    }
}
