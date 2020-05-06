package com.sparkit.interpreter.compiler.visitors;


import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.compiler.ast.types.ListItemAccess;
import com.sparkit.interpreter.compiler.parser.StafBaseVisitor;
import com.sparkit.interpreter.compiler.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

public class ListItemAccessVisitor extends StafBaseVisitor<AbstractStafObject> {
    @Autowired
    private ExpressionVisitor expressionVisitor;
    @Override
    public AbstractStafObject visitList_item_access(StafParser.List_item_accessContext ctx) {
        return null;/*
        AbstractStafObject variable = new StafVariable(ctx.variable().getText());
        AbstractStafObject itemIndex = new ExpressionVisitor().visitExpression(ctx.expression());
        return new ListItemAccess(variable, itemIndex);*/
    }

    public AbstractStafObject visitList_item_access(AbstractStafObject parent, StafParser.List_item_accessContext ctx) {
        AbstractStafObject itemIndex = expressionVisitor.visitExpression(ctx.expression());
        return new ListItemAccess(parent, itemIndex);
    }
}
