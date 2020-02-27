package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.ast.IStatement;

public class StatementVisitor extends StafBaseVisitor<IStatement> {
    @Override
    public IStatement visitStatement(StafParser.StatementContext ctx) {
        StafParser.AssignmentContext assignmentContext = ctx.assignment();
        if (assignmentContext != null) {
            return new AssignmentVisitor().visitAssignment(assignmentContext);
        }
        StafParser.Keyword_callContext keywordCallContext = ctx.keyword_call();
        if (keywordCallContext != null) {
            return new KeywordCallVisitor().visitKeyword_call(keywordCallContext);
        }
        StafParser.For_statContext forStatContext = ctx.for_stat();
        if (forStatContext != null) {
            return new ForStatementVisitor().visitFor_stat(forStatContext);
        }
        return super.visitStatement(ctx);
    }
}
