package com.sparkit.staf.visitors;

import com.sparkit.staf.ast.Expression;
import com.sparkit.staf.ast.types.DictionaryItemAccess;
import com.sparkit.staf.ast.types.ListItemAccess;
import com.sparkit.staf.ast.types.StafVariable;
import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.ast.types.AbstractStafObject;
import com.sparkit.staf.ast.StafTypes;
import org.antlr.v4.runtime.RuleContext;

public class VariableReferenceVisitor extends StafBaseVisitor<AbstractStafObject> {
    @Override
    public AbstractStafObject visitVariable_reference(StafParser.Variable_referenceContext ctx) {
        StafParser.VariableContext variableContext = ctx.variable();
        AbstractStafObject parentVarRefObject = new StafVariable(variableContext.getText());

        StafParser.Dictionary_item_accessContext dictionaryItemAccessContext;
        StafParser.List_item_accessContext listItemAccessContext;
        int i = 0;
        do {
            dictionaryItemAccessContext = ctx.dictionary_item_access(i);
            listItemAccessContext = ctx.list_item_access(i);
            if (dictionaryItemAccessContext != null) {
                parentVarRefObject = new DictionaryItemAccess(parentVarRefObject, dictionaryItemAccessContext.IDENTIFIER().getText());
            }
            if (listItemAccessContext != null) {
                AbstractStafObject listIndexExpr = new ExpressionVisitor().visitExpression(listItemAccessContext.expression());
                parentVarRefObject = new ListItemAccess(parentVarRefObject, listIndexExpr);
            }
            i++;
        } while (dictionaryItemAccessContext != null && listItemAccessContext != null);

        return parentVarRefObject;
    }
}
