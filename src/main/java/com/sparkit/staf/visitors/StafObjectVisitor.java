package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.ast.types.AbstractStafObject;

public class StafObjectVisitor extends StafBaseVisitor<AbstractStafObject> {

    @Override
    public AbstractStafObject visitObject(StafParser.ObjectContext ctx) {
        StafParser.Complex_objectContext complexObjectContext = ctx.complex_object();
        if (complexObjectContext != null) {
            return new ComplexObjectVisitor().visitComplex_object(complexObjectContext);
        }
        StafParser.Scalar_objectContext scalarObjectContext = ctx.scalar_object();
        if (scalarObjectContext != null) {
            return new ScalarObjectVisitor().visitScalar_object(scalarObjectContext);
        }
        StafParser.ExpressionContext expressionContext = ctx.expression();
        if (expressionContext != null) {
            return new ExpressionVisitor().visitExpression(expressionContext);
        }
        return super.visitObject(ctx);
    }
}
