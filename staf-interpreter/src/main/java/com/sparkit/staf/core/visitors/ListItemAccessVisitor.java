package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;

public class ListItemAccessVisitor extends StafBaseVisitor<AbstractStafObject> {
    @Override
    public AbstractStafObject visitList_item_access(StafParser.List_item_accessContext ctx) {
        return null;/*
        AbstractStafObject variable = new StafVariable(ctx.variable().getText());
        AbstractStafObject itemIndex = new ExpressionVisitor().visitExpression(ctx.expression());
        return new ListItemAccess(variable, itemIndex);*/
    }
}
