package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.IStatement;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ForStatementBodyVisitor extends StafBaseVisitor<List<IStatement>> {
    @Autowired
    private StatementVisitor statementVisitor;

    @Override
    public List<IStatement> visitFor_stat_body(StafParser.For_stat_bodyContext ctx) {
        List<IStatement> statements = new ArrayList<>();
        for (StafParser.StatementContext statementContext : ctx.statement()) {
            statements.add(statementVisitor.visitStatement(statementContext));
        }
        return statements;
    }
}
