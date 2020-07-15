package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.KeywordCall;
import com.sparkit.staf.core.ast.types.StafBoolean;
import com.sparkit.staf.core.runtime.interpreter.MemoryMap;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.reports.IReportableBlock;
import com.sparkit.staf.core.runtime.reports.StatementReport;
import lombok.Getter;

import java.util.List;

public class RunKeywordIf implements IStatement, IReportableBlock {
    @Getter
    private final AbstractStafObject condition;
    @Getter
    private final KeywordCall keywordCall;
    private List<StatementReport> reports;

    public RunKeywordIf(AbstractStafObject condition, KeywordCall keywordCall) {
        this.condition = condition;
        this.keywordCall = keywordCall;
    }

    @Override
    public Object execute(MemoryMap globalMemory, MemoryMap localMemory, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        StafBoolean conditionResult = (StafBoolean)
                condition.evaluate(globalMemory, localMemory, keywordLibrariesRepository);
        if ((boolean) conditionResult.getValue()) {
            keywordCall.execute(globalMemory, localMemory, keywordLibrariesRepository);
        }
        return null;
    }

    @Override
    public List<StatementReport> getStatementReports() {
        return null;
    }

    @Override
    public void setStatementReports(List<StatementReport> reports) {

    }
}
