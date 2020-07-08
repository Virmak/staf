package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.runtime.interpreter.IStatementBlock;
import com.sparkit.staf.core.runtime.reports.StatementReport;
import lombok.Data;

import java.util.List;

@Data
public class TestCaseDeclaration implements IStatementBlock {
    private String name;
    private List<IStatement> statements;
    private List<StatementReport> reports;
    private int order;
    private boolean isDefaultOrder;
    private boolean ignored = false;
    private String filePath;
    private int lineNumber;

    public TestCaseDeclaration(String name, List<IStatement> statements) {
        this.name = name;
        this.statements = statements;
    }

    public TestCaseDeclaration() {
    }

    @Override
    public List<StatementReport> getStatementReports() {
        return reports;
    }

    @Override
    public void setStatementReports(List<StatementReport> reports) {
        this.reports = reports;
    }

    public void setDefaultOrder(int order) {
        this.order = order;
        this.isDefaultOrder = true;
    }
}
