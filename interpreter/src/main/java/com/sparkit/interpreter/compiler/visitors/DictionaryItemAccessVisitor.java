package com.sparkit.interpreter.compiler.visitors;


import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.compiler.ast.types.DictionaryItemAccess;
import com.sparkit.interpreter.compiler.parser.StafBaseVisitor;
import com.sparkit.interpreter.compiler.parser.StafParser;

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
