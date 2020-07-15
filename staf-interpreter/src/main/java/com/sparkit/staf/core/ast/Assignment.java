package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.KeywordCall;
import com.sparkit.staf.core.ast.types.StafVariable;
import com.sparkit.staf.core.runtime.interpreter.MemoryMap;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
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
    public Object execute(MemoryMap globalMemory, MemoryMap localMemory, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        if (value instanceof KeywordCall) {
            KeywordCall keywordCall = (KeywordCall) value;
            Object returnObj = keywordCall.execute(globalMemory, localMemory, keywordLibrariesRepository);
            this.reports = keywordCall.getStatementReports();
            if (localMemory != null && localMemory.getVariablesMap().containsKey(object.getValue().toString())) {
                localMemory.getVariablesMap().put(object.getValue().toString(), returnObj);
            } else if (globalMemory.getVariablesMap().containsKey(object.getValue().toString())) {
                globalMemory.getVariablesMap().put(object.getValue().toString(), returnObj);
            } else if (localMemory != null) {
                localMemory.getVariablesMap().put(object.getValue().toString(), returnObj);
            }
            return returnObj;
        }
        if (localMemory != null && localMemory.getVariablesMap().containsKey(object.getValue().toString())) {
            localMemory.getVariablesMap().put(object.getValue().toString(),
                    value.evaluate(globalMemory, localMemory, keywordLibrariesRepository));
        } else if (globalMemory.getVariablesMap().containsKey(object.getValue().toString())) {
            globalMemory.getVariablesMap().put(object.getValue().toString(),
                    value.evaluate(globalMemory, localMemory, keywordLibrariesRepository));
        } else if (localMemory != null) {
            localMemory.getVariablesMap().put(object.getValue().toString(),
                    value.evaluate(globalMemory, localMemory, keywordLibrariesRepository));
        }

        if (value instanceof Expression || value instanceof StafVariable) {
            return value.evaluate(globalMemory, localMemory, keywordLibrariesRepository);
        }
        return (value);
    }
}
