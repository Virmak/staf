package com.sparkit.interpreter.compiler.visitors;

import com.sparkit.interpreter.compiler.ast.statement.IStatement;
import com.sparkit.interpreter.compiler.parser.StafBaseVisitor;
import com.sparkit.interpreter.compiler.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TestCaseBodyVisitor extends StafBaseVisitor<List<IStatement>> {
    @Autowired
    private StatementVisitor statementVisitor;

    @Override
    public List<IStatement> visitTest_case_body(StafParser.Test_case_bodyContext ctx) {
        List<IStatement> statements = new ArrayList<>();
        for (StafParser.StatementContext statementContext : ctx.statement()) {
            statements.add(statementVisitor.visitStatement(statementContext));
        }
        return statements;
    }
}
