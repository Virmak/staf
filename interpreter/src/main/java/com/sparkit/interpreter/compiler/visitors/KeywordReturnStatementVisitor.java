package com.sparkit.interpreter.compiler.visitors;

import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.compiler.parser.StafBaseVisitor;
import com.sparkit.interpreter.compiler.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

public class KeywordReturnStatementVisitor extends StafBaseVisitor<AbstractStafObject> {
    @Autowired
    private StafObjectVisitor stafObjectVisitor;

    @Override
    public AbstractStafObject visitKeyword_return_stat(StafParser.Keyword_return_statContext ctx) {
        StafParser.ObjectContext objectContext = ctx.object();
        if (objectContext != null) {
            return stafObjectVisitor.visitObject(ctx.object());
        }
        return null;
    }
}
