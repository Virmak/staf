package com.sparkit.staf.core.ast;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.StafVariable;
import com.sparkit.staf.core.runtime.interpreter.IStafLoop;
import com.sparkit.staf.core.runtime.interpreter.IStatementBlock;
import com.sparkit.staf.core.runtime.interpreter.MemoryMap;
import com.sparkit.staf.core.runtime.interpreter.StatementBlockExecutor;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.reports.StatementReport;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class ForStatement implements IStatement, IStatementBlock, IStafLoop {
    @JsonIgnore
    private final StatementBlockExecutor blockExecutor;
    private StafVariable loopVariable;
    private AbstractStafObject iterator;
    @Getter
    private List<IStatement> statements;
    private List<StatementReport> statementReports;

    public ForStatement(StatementBlockExecutor blockExecutor) {
        this.blockExecutor = blockExecutor;
    }

    @Override
    public Object execute(MemoryMap globalMemory, MemoryMap localMemory, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        return blockExecutor.executeIterable(this, globalMemory, localMemory, keywordLibrariesRepository);
    }
}
