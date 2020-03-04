package com.sparkit.staf.visitors;

import com.sparkit.staf.ast.types.StafVariable;
import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.ast.types.AbstractStafObject;
import com.sparkit.staf.ast.StafTypes;

public class VariableReferenceVisitor extends StafBaseVisitor<AbstractStafObject> {
    @Override
    public AbstractStafObject visitVariable_reference(StafParser.Variable_referenceContext ctx) {
        StafParser.List_item_accessContext listItemAccessContext = ctx.list_item_access();
        if (listItemAccessContext != null) {
            return new ListItemAccessVisitor().visitList_item_access(listItemAccessContext);
        }
        StafParser.Dictionary_item_accessContext dictionaryItemAccessContext = ctx.dictionary_item_access();
        if (dictionaryItemAccessContext != null) {
            return new DictionaryItemAccessVisitor().visitDictionary_item_access(dictionaryItemAccessContext);
        }
        return new StafVariable(ctx.getText());
    }
}
