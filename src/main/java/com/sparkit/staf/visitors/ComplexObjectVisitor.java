package com.sparkit.staf.visitors;

import com.sparkit.staf.ast.types.AbstractStafObject;
import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;

public class ComplexObjectVisitor extends StafBaseVisitor<AbstractStafObject> {
    @Override
    public AbstractStafObject visitComplex_object(StafParser.Complex_objectContext ctx) {
        StafParser.ListLiteralContext listLiteralContext = ctx.listLiteral();
        if (listLiteralContext != null) {
            return new ListLiteralVisitor().visitListLiteral(listLiteralContext);
        }
        StafParser.DictionaryLiteralContext dictionaryLiteralContext = ctx.dictionaryLiteral();
        if (dictionaryLiteralContext != null) {
            return new DictionaryLiteralVisitor().visitDictionaryLiteral(dictionaryLiteralContext);
        }
        return super.visitComplex_object(ctx);
    }
}
