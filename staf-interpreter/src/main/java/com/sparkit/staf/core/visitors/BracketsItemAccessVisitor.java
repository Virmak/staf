package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.BracketsItemAccess;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

public class BracketsItemAccessVisitor extends StafBaseVisitor<BracketsItemAccess> {
    @Autowired
    private ExpressionVisitor expressionVisitor;


    @Override
    public BracketsItemAccess visitBrackets_item_access(StafParser.Brackets_item_accessContext ctx) {
        return null;
    }

    public BracketsItemAccess visitBrackets_item_access(AbstractStafObject parent, StafParser.Brackets_item_accessContext ctx) {
        AbstractStafObject itemIndex = expressionVisitor.visitExpression(ctx.expression());
        return new BracketsItemAccess(parent, itemIndex);
    }
}
