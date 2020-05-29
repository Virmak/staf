package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.KeywordCall;
import com.sparkit.staf.core.runtime.interpreter.StatementBlockExecutor;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.reports.IReportableBlock;
import com.sparkit.staf.core.runtime.reports.StatementReport;

import java.util.List;

public class Assignment implements IStatement, IReportableBlock {
    protected AbstractStafObject object;
    protected AbstractStafObject value;
    private List<StatementReport> reports;

    public Assignment(AbstractStafObject object, AbstractStafObject value) {
        this.object = object;
        this.value = value;
    }

    public Assignment() {
    }

    public AbstractStafObject getObject() {
        return object;
    }

    public void setObject(AbstractStafObject object) {
        this.object = object;
    }

    public AbstractStafObject getValue() {
        return value;
    }

    public void setValue(AbstractStafObject value) {
        this.value = value;
    }


    @Override
    public Object execute(StatementBlockExecutor blockExecutor, SymbolsTable globalSymbolsTable, SymbolsTable localSymbolsTable,
                          KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        if (value instanceof KeywordCall) {
            KeywordCall keywordCall = (KeywordCall) value;
            Object returnObj = keywordCall.execute(blockExecutor, globalSymbolsTable, localSymbolsTable, keywordLibrariesRepository);
            this.reports = keywordCall.getStatementReports();
            if (localSymbolsTable != null && localSymbolsTable.getSymbolsMap().containsKey(object.getValue().toString())) {
                localSymbolsTable.getSymbolsMap().put(object.getValue().toString(), returnObj);
            } else if (globalSymbolsTable.getSymbolsMap().containsKey(object.getValue().toString())) {
                globalSymbolsTable.getSymbolsMap().put(object.getValue().toString(), returnObj);
            } else if (localSymbolsTable != null) {
                localSymbolsTable.getSymbolsMap().put(object.getValue().toString(), returnObj);
            }
            return returnObj;
        }
        if (localSymbolsTable != null && localSymbolsTable.getSymbolsMap().containsKey(object.getValue().toString())) {
            localSymbolsTable.getSymbolsMap().put(object.getValue().toString(),
                    value.evaluate(blockExecutor, globalSymbolsTable, localSymbolsTable, keywordLibrariesRepository));
        } else if (globalSymbolsTable.getSymbolsMap().containsKey(object.getValue().toString())) {
            globalSymbolsTable.getSymbolsMap().put(object.getValue().toString(),
                    value.evaluate(blockExecutor, globalSymbolsTable, localSymbolsTable, keywordLibrariesRepository));
        } else if (localSymbolsTable != null) {
            localSymbolsTable.getSymbolsMap().put(object.getValue().toString(),
                    value.evaluate(blockExecutor, globalSymbolsTable, localSymbolsTable, keywordLibrariesRepository));
        }
        return (value);
    }


    @Override
    public String toString() {
        return "Assignment : " + object + " = " + value;
    }

    @Override
    public List<StatementReport> getStatementReports() {
        return reports;
    }

    @Override
    public void setStatementReports(List<StatementReport> reports) {
        this.reports = reports;
    }
}
