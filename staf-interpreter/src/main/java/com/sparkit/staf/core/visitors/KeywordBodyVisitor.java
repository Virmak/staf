package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import com.sparkit.staf.core.ast.IStatement;

import java.util.ArrayList;
import java.util.List;

public class KeywordBodyVisitor extends StafBaseVisitor<List<IStatement>> {
    @Override
    public List<IStatement> visitKeyword_body(StafParser.Keyword_bodyContext ctx) {
        List<IStatement> statements = new ArrayList<>();
        for (StafParser.StatementContext statementContext: ctx.statement()) {
            statements.add(new StatementVisitor().visitStatement(statementContext));
        }
        return statements;
    }
}
