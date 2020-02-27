package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.types.IStatement;

import java.util.ArrayList;
import java.util.List;

public class TestCaseBodyVisitor extends StafBaseVisitor<List<IStatement>> {
    @Override
    public List<IStatement> visitTest_case_body(StafParser.Test_case_bodyContext ctx) {
        List<IStatement> statements = new ArrayList<>();
        for (StafParser.StatementContext statementContext : ctx.statement()) {
            statements.add(new StatementVisitor().visitStatement(statementContext));
        }
        return statements;
    }
}
