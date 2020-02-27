package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.ast.ListItemAccess;
import com.sparkit.staf.ast.StafObject;
import com.sparkit.staf.ast.StafTypes;

public class ListItemAccessVisitor extends StafBaseVisitor<StafObject> {
    @Override
    public StafObject visitList_item_access(StafParser.List_item_accessContext ctx) {
        StafObject variable = new StafObject(ctx.variable().getText(), StafTypes.VAR_REF);
        StafObject itemIndex = new StafObjectVisitor().visitObject(ctx.object());
        return new ListItemAccess(variable, itemIndex);
    }
}
