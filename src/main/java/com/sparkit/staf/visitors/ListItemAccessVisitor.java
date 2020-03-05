package com.sparkit.staf.visitors;

import com.sparkit.staf.ast.types.StafVariable;
import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.ast.types.ListItemAccess;
import com.sparkit.staf.ast.types.AbstractStafObject;

public class ListItemAccessVisitor extends StafBaseVisitor<AbstractStafObject> {
    @Override
    public AbstractStafObject visitList_item_access(StafParser.List_item_accessContext ctx) {
        return null;/*
        AbstractStafObject variable = new StafVariable(ctx.variable().getText());
        AbstractStafObject itemIndex = new ExpressionVisitor().visitExpression(ctx.expression());
        return new ListItemAccess(variable, itemIndex);*/
    }
}
