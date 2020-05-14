package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
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
