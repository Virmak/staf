package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import com.sparkit.staf.core.ast.IStatement;

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
        StafParser.Run_keyword_ifContext runKeywordIfContext = ctx.run_keyword_if();
        if (runKeywordIfContext != null) {
            return new RunKeywordIfVisitor().visitRun_keyword_if(runKeywordIfContext);
        }
        return super.visitStatement(ctx);
    }
}
