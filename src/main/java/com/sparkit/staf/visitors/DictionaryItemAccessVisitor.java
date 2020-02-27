package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.types.DictionaryItemAccess;
import com.sparkit.staf.types.StafObject;
import com.sparkit.staf.types.StafTypes;

public class DictionaryItemAccessVisitor extends StafBaseVisitor<StafObject> {
    /* need to support nested items access */
    @Override
    public StafObject visitDictionary_item_access(StafParser.Dictionary_item_accessContext ctx) {
        StafObject variable = new StafObject(ctx.variable().getText(), StafTypes.VAR_REF);
        return new DictionaryItemAccess(variable, ctx.IDENTIFIER(0).getText());
    }
}
