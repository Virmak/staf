package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;

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
