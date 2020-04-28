package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.ExitLoopStatement;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;

public class ExitLoopVisitor extends StafBaseVisitor<ExitLoopStatement> {
    @Override
    public ExitLoopStatement visitExit_loop(StafParser.Exit_loopContext ctx) {
        return new ExitLoopStatement();
    }
}
