package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

public class ComplexObjectVisitor extends StafBaseVisitor<AbstractStafObject> {
    @Autowired
    private ListLiteralVisitor listLiteralVisitor;
    @Autowired
    private DictionaryLiteralVisitor dictionaryLiteralVisitor;

    @Override
    public AbstractStafObject visitComplex_object(StafParser.Complex_objectContext ctx) {
        StafParser.ListLiteralContext listLiteralContext = ctx.listLiteral();
        if (listLiteralContext != null) {
            return listLiteralVisitor.visitListLiteral(listLiteralContext);
        }
        StafParser.DictionaryLiteralContext dictionaryLiteralContext = ctx.dictionaryLiteral();
        if (dictionaryLiteralContext != null) {
            return dictionaryLiteralVisitor.visitDictionaryLiteral(dictionaryLiteralContext);
        }
        return super.visitComplex_object(ctx);
    }
}
