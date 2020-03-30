package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;

public class ScalarObjectVisitor extends StafBaseVisitor<AbstractStafObject> {
    @Override
    public AbstractStafObject visitScalar_object(StafParser.Scalar_objectContext ctx) {
        StafParser.PrimitiveContext primitiveContext = ctx.primitive();
        if (primitiveContext != null) {
            return new PrimitiveVisitor().visitPrimitive(primitiveContext);
        }
        StafParser.Variable_referenceContext variableReferenceContext = ctx.variable_reference();
        if (variableReferenceContext != null) {
            return new VariableReferenceVisitor().visitVariable_reference(variableReferenceContext);
        }
        StafParser.Keyword_callContext keywordCallContext = ctx.keyword_call();
        if (keywordCallContext != null) {
            return new KeywordCallVisitor().visitKeyword_call(keywordCallContext);
        }
        return super.visitScalar_object(ctx);
    }
}
