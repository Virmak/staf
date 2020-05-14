package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.IStatement;
import com.sparkit.staf.core.runtime.reports.IReportableBlock;

import java.util.List;

public interface IStatementBlock extends IReportableBlock {
    List<IStatement> getStatements();
}
