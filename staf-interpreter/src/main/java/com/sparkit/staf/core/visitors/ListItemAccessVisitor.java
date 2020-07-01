package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.ListItemAccess;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

public class ListItemAccessVisitor extends StafBaseVisitor<ListItemAccess> {
    @Autowired
    private ExpressionVisitor expressionVisitor;

    @Override
    public ListItemAccess visitList_item_access(StafParser.List_item_accessContext ctx) {
        return null; // used by auto generated parser
    }

    public ListItemAccess visitList_item_access(AbstractStafObject parent, StafParser.List_item_accessContext ctx) {
        AbstractStafObject itemIndex = expressionVisitor.visitExpression(ctx.expression());
        return new ListItemAccess(parent, itemIndex);
    }
}
