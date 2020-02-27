package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.types.ForStatement;
import com.sparkit.staf.types.StafVariable;

public class ForStatementVisitor extends StafBaseVisitor<ForStatement> {
    @Override
    public ForStatement visitFor_stat(StafParser.For_statContext ctx) {
        ForStatement forStatement = new ForStatement();
        forStatement.setVar(new StafVariable(ctx.variable().getText(), null));
        forStatement.setIterator(new StafObjectVisitor().visitObject(ctx.object()));
        forStatement.setStatementList(new ForStatementBodyVisitor().visitFor_stat_body(ctx.for_stat_body()));
        return forStatement;
    }
}
