package com.sparkit.staf.core.ast;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.StafVariable;
import com.sparkit.staf.core.runtime.interpreter.IStafIterable;
import com.sparkit.staf.core.runtime.interpreter.IStatementBlock;
import com.sparkit.staf.core.runtime.interpreter.StatementBlockExecutor;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.reports.StatementReport;
import lombok.Data;

import java.util.List;

@Data
public class ForStatement implements IStatement, IStatementBlock, IStafIterable {
    @JsonIgnore
    private final StatementBlockExecutor blockExecutor;
    private StafVariable loopVariable;
    private AbstractStafObject iterator;
    private List<IStatement> statementList;
    private List<StatementReport> statementReports;

    public ForStatement(StatementBlockExecutor blockExecutor) {
        this.blockExecutor = blockExecutor;
    }

    @Override
    public List<IStatement> getStatements() {
        return statementList;
    }

    @Override
    public Object execute(SymbolsTable globalSymbolsTable, SymbolsTable localSymbolsTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        return blockExecutor.executeIterable(this, globalSymbolsTable, localSymbolsTable, keywordLibrariesRepository);
    }
}
