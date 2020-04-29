package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.DictionaryItemAccess;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;

public class DictionaryItemAccessVisitor extends StafBaseVisitor<AbstractStafObject> {
    /* need to support nested items access */
    @Override
    public AbstractStafObject visitDictionary_item_access(StafParser.Dictionary_item_accessContext ctx) {
        return null;
    }

    public AbstractStafObject visitDictionary_item_access(AbstractStafObject parent, StafParser.Dictionary_item_accessContext ctx) {
        return new DictionaryItemAccess(parent, ctx.IDENTIFIER().getText());
    }
}
