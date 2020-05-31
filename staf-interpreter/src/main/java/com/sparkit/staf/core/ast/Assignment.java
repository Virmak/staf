package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.KeywordCall;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.reports.IReportableBlock;
import com.sparkit.staf.core.runtime.reports.StatementReport;
import lombok.Getter;

import java.util.List;

public class Assignment implements IStatement, IReportableBlock {
    @Getter
    private final AbstractStafObject object;
    private final AbstractStafObject value;
    private List<StatementReport> reports;

    public Assignment(AbstractStafObject object, AbstractStafObject value) {
        this.object = object;
        this.value = value;
    }

    @Override
    public List<StatementReport> getStatementReports() {
        return reports;
    }

    @Override
    public void setStatementReports(List<StatementReport> reports) {
        this.reports = reports;
    }

    @Override
    public String toString() {
        return "Assignment : " + object + " = " + value;
    }

    @Override
    public Object execute(SymbolsTable globalSymbolsTable, SymbolsTable localSymbolsTable) throws Throwable {
        if (value instanceof KeywordCall) {
            KeywordCall keywordCall = (KeywordCall) value;
            Object returnObj = keywordCall.execute(globalSymbolsTable, localSymbolsTable);
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
                    value.evaluate(globalSymbolsTable, localSymbolsTable));
        } else if (globalSymbolsTable.getSymbolsMap().containsKey(object.getValue().toString())) {
            globalSymbolsTable.getSymbolsMap().put(object.getValue().toString(),
                    value.evaluate(globalSymbolsTable, localSymbolsTable));
        } else if (localSymbolsTable != null) {
            localSymbolsTable.getSymbolsMap().put(object.getValue().toString(),
                    value.evaluate(globalSymbolsTable, localSymbolsTable));
        }
        return (value);
    }
}
