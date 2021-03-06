package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

public class StafObjectVisitor extends StafBaseVisitor<AbstractStafObject> {
    @Autowired
    private ComplexObjectVisitor complexObjectVisitor;
    @Autowired
    private ScalarObjectVisitor scalarObjectVisitor;
    @Autowired
    private ExpressionVisitor expressionVisitor;

    @Override
    public AbstractStafObject visitObject(StafParser.ObjectContext ctx) {
        StafParser.Complex_objectContext complexObjectContext = ctx.complex_object();
        if (complexObjectContext != null) {
            return complexObjectVisitor.visitComplex_object(complexObjectContext);
        }
        StafParser.Scalar_objectContext scalarObjectContext = ctx.scalar_object();
        if (scalarObjectContext != null) {
            return scalarObjectVisitor.visitScalar_object(scalarObjectContext);
        }
        StafParser.ExpressionContext expressionContext = ctx.expression();
        if (expressionContext != null) {
            return expressionVisitor.visitExpression(expressionContext);
        }
        return super.visitObject(ctx);
    }
}
