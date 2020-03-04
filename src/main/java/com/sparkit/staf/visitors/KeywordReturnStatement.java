package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.ast.types.AbstractStafObject;

public class KeywordReturnStatement extends StafBaseVisitor<AbstractStafObject> {
    @Override
    public AbstractStafObject visitKeyword_return_stat(StafParser.Keyword_return_statContext ctx) {
        StafParser.ObjectContext objectContext = ctx.object();
        if (objectContext != null) {
            return new StafObjectVisitor().visitObject(ctx.object());
        }
        return null;
    }
}
