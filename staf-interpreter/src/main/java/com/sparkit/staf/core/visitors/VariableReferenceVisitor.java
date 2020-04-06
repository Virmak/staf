package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.types.DictionaryItemAccess;
import com.sparkit.staf.core.ast.types.ListItemAccess;
import com.sparkit.staf.core.ast.types.StafVariable;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

public class VariableReferenceVisitor extends StafBaseVisitor<AbstractStafObject> {
    @Autowired
    private ExpressionVisitor expressionVisitor;
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
                AbstractStafObject listIndexExpr = expressionVisitor.visitExpression(listItemAccessContext.expression());
                parentVarRefObject = new ListItemAccess(parentVarRefObject, listIndexExpr);
            }
            i++;
        } while (dictionaryItemAccessContext != null && listItemAccessContext != null);

        return parentVarRefObject;
    }
}
