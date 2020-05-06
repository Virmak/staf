package com.sparkit.interpreter.compiler.visitors;

import com.sparkit.interpreter.compiler.ast.statement.ExitLoopStatement;
import com.sparkit.interpreter.compiler.parser.StafBaseVisitor;
import com.sparkit.interpreter.compiler.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

public class ExitLoopVisitor extends StafBaseVisitor<ExitLoopStatement> {
    @Autowired
    private ExpressionVisitor expressionVisitor;
    @Override
    public ExitLoopStatement visitExit_loop(StafParser.Exit_loopContext ctx) {
        StafParser.Exit_loop_conditionContext exitLoopConditionContext = ctx.exit_loop_condition();
        if (exitLoopConditionContext != null) {
            return new ExitLoopStatement(expressionVisitor.visitExpression(exitLoopConditionContext.expression()));
        }
        return new ExitLoopStatement();
    }
}
