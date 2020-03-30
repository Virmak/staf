package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;

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
