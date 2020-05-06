package com.sparkit.interpreter.compiler.visitors;


import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.compiler.parser.StafBaseVisitor;
import com.sparkit.interpreter.compiler.parser.StafParser;
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
