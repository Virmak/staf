package com.sparkit.staf.visitors;

import com.sparkit.staf.ast.types.StafVariable;
import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.ast.types.DictionaryItemAccess;
import com.sparkit.staf.ast.types.AbstractStafObject;

public class DictionaryItemAccessVisitor extends StafBaseVisitor<AbstractStafObject> {
    /* need to support nested items access */
    @Override
    public AbstractStafObject visitDictionary_item_access(StafParser.Dictionary_item_accessContext ctx) {
        AbstractStafObject variable = new StafVariable(ctx.variable().getText());
        return new DictionaryItemAccess(variable, ctx.IDENTIFIER(0).getText());
    }
}
