package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.IStatement;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

public class StatementVisitor extends StafBaseVisitor<IStatement> {
    @Autowired
    private AssignmentVisitor assignmentVisitor;
    @Autowired
    private KeywordCallVisitor keywordCallVisitor;
    @Autowired
    private ForStatementVisitor forStatementVisitor;
    @Autowired
    private RunKeywordIfVisitor runKeywordIfVisitor;

    @Override
    public IStatement visitStatement(StafParser.StatementContext ctx) {
        StafParser.AssignmentContext assignmentContext = ctx.assignment();
        if (assignmentContext != null) {
            return assignmentVisitor.visitAssignment(assignmentContext);
        }
        StafParser.Keyword_callContext keywordCallContext = ctx.keyword_call();
        if (keywordCallContext != null) {
            return keywordCallVisitor.visitKeyword_call(keywordCallContext);
        }
        StafParser.For_statContext forStatContext = ctx.for_stat();
        if (forStatContext != null) {
            return forStatementVisitor.visitFor_stat(forStatContext);
        }
        StafParser.Run_keyword_ifContext runKeywordIfContext = ctx.run_keyword_if();
        if (runKeywordIfContext != null) {
            return runKeywordIfVisitor.visitRun_keyword_if(runKeywordIfContext);
        }
        return super.visitStatement(ctx);
    }
}
