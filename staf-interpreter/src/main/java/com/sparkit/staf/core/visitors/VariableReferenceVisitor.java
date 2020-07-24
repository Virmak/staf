package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.StafVariable;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

public class VariableReferenceVisitor extends StafBaseVisitor<AbstractStafObject> {
    @Autowired
    private BracketsItemAccessVisitor listItemAccessVisitor;
    @Autowired
    private DotItemAccessVisitor dictionaryItemAccessVisitor;

    @Override
    public AbstractStafObject visitVariable_reference(StafParser.Variable_referenceContext ctx) {
        StafParser.VariableContext variableContext = ctx.variable();
        if (variableContext != null) {
            return new StafVariable(variableContext.getText());
        }
        AbstractStafObject parentVarRefObject = null;
        StafParser.Variable_referenceContext variableReferenceContext = ctx.variable_reference();
        if (variableReferenceContext != null) {
            parentVarRefObject = visitVariable_reference(variableReferenceContext);
        }
        StafParser.Dot_item_accessContext dotItemAccessContext = ctx.dot_item_access();
        if (dotItemAccessContext != null) {
            return dictionaryItemAccessVisitor.visitDot_item_access(parentVarRefObject, dotItemAccessContext);
        }
        StafParser.Brackets_item_accessContext listItemAccessContext = ctx.brackets_item_access();
        if (listItemAccessContext != null) {
            return listItemAccessVisitor.visitBrackets_item_access(parentVarRefObject, listItemAccessContext);
        }
        return super.visitVariable_reference(ctx);
    }
}
