package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.DotItemAccess;
import com.sparkit.staf.core.ast.types.StafString;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

public class DotItemAccessVisitor extends StafBaseVisitor<AbstractStafObject> {
    @Autowired
    private VariableReferenceVisitor variableReferenceVisitor;

    @Override
    public AbstractStafObject visitDot_item_access(StafParser.Dot_item_accessContext ctx) {
        return null;
    }

    public AbstractStafObject visitDot_item_access(AbstractStafObject parent, StafParser.Dot_item_accessContext ctx) {
        return new DotItemAccess(parent, new StafString(ctx.IDENTIFIER().getText()));
    }
}
