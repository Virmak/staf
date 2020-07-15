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
    private final AbstractStafObject leftHandSide;
    @Getter
    private final AbstractStafObject rightHandSide;
    private List<StatementReport> reports;

    public Assignment(AbstractStafObject leftHandSide, AbstractStafObject rightHandSide) {
        this.leftHandSide = leftHandSide;
        this.rightHandSide = rightHandSide;
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
        return "Assignment : " + leftHandSide + " = " + rightHandSide;
    }

    @Override
    public Object execute(MemoryMap globalMemory, MemoryMap localMemory, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        if (rightHandSide instanceof KeywordCall) {
            KeywordCall keywordCall = (KeywordCall) rightHandSide;
            Object returnObj = keywordCall.execute(globalMemory, localMemory, keywordLibrariesRepository);
            this.reports = keywordCall.getStatementReports();
            if (localMemory != null && localMemory.getVariablesMap().containsKey(leftHandSide.getValue().toString())) {
                localMemory.getVariablesMap().put(leftHandSide.getValue().toString(), returnObj);
            } else if (globalMemory.getVariablesMap().containsKey(leftHandSide.getValue().toString())) {
                globalMemory.getVariablesMap().put(leftHandSide.getValue().toString(), returnObj);
            } else if (localMemory != null) {
                localMemory.getVariablesMap().put(leftHandSide.getValue().toString(), returnObj);
            }
            return returnObj;
        }
        if (localMemory != null && localMemory.getVariablesMap().containsKey(leftHandSide.getValue().toString())) {
            localMemory.getVariablesMap().put(leftHandSide.getValue().toString(),
                    rightHandSide.evaluate(globalMemory, localMemory, keywordLibrariesRepository));
        } else if (globalMemory.getVariablesMap().containsKey(leftHandSide.getValue().toString())) {
            globalMemory.getVariablesMap().put(leftHandSide.getValue().toString(),
                    rightHandSide.evaluate(globalMemory, localMemory, keywordLibrariesRepository));
        } else if (localMemory != null) {
            localMemory.getVariablesMap().put(leftHandSide.getValue().toString(),
                    rightHandSide.evaluate(globalMemory, localMemory, keywordLibrariesRepository));
        }

        if (rightHandSide instanceof Expression || rightHandSide instanceof StafVariable) {
            return rightHandSide.evaluate(globalMemory, localMemory, keywordLibrariesRepository);
        }
        return (rightHandSide);
    }
}
