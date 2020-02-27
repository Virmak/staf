package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.types.StafObject;
import com.sparkit.staf.types.StafTypes;

public class VariableReferenceVisitor extends StafBaseVisitor<StafObject> {
    @Override
    public StafObject visitVariable_reference(StafParser.Variable_referenceContext ctx) {
        StafParser.List_item_accessContext listItemAccessContext = ctx.list_item_access();
        if (listItemAccessContext != null) {
            return new ListItemAccessVisitor().visitList_item_access(listItemAccessContext);
        }
        StafParser.Dictionary_item_accessContext dictionaryItemAccessContext = ctx.dictionary_item_access();
        if (dictionaryItemAccessContext != null) {
            return new DictionaryItemAccessVisitor().visitDictionary_item_access(dictionaryItemAccessContext);
        }
        return new StafObject(ctx.getText(), StafTypes.VAR_REF);
    }
}
