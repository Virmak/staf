package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.types.IStatement;

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
