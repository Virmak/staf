package com.sparkit.interpreter.compiler.visitors;


import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.compiler.parser.StafBaseVisitor;
import com.sparkit.interpreter.compiler.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

public class ScalarObjectVisitor extends StafBaseVisitor<AbstractStafObject> {
    @Autowired
    private PrimitiveVisitor primitiveVisitor;
    @Autowired
    private VariableReferenceVisitor variableReferenceVisitor;
    @Autowired
    private KeywordCallVisitor keywordCallVisitor;

    @Override
    public AbstractStafObject visitScalar_object(StafParser.Scalar_objectContext ctx) {
        StafParser.PrimitiveContext primitiveContext = ctx.primitive();
        if (primitiveContext != null) {
            return primitiveVisitor.visitPrimitive(primitiveContext);
        }
        StafParser.Variable_referenceContext variableReferenceContext = ctx.variable_reference();
        if (variableReferenceContext != null) {
            return variableReferenceVisitor.visitVariable_reference(variableReferenceContext);
        }
        StafParser.Keyword_callContext keywordCallContext = ctx.keyword_call();
        if (keywordCallContext != null) {
            return keywordCallVisitor.visitKeyword_call(keywordCallContext);
        }
        return super.visitScalar_object(ctx);
    }
}
