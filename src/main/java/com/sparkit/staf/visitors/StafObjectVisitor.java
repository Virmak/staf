package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.types.StafObject;

public class StafObjectVisitor extends StafBaseVisitor<StafObject> {

    @Override
    public StafObject visitObject(StafParser.ObjectContext ctx) {
        StafParser.PrimitiveContext primitiveContext = ctx.primitive();
        if (primitiveContext != null) {
            return new PrimitiveVisitor().visitPrimitive(primitiveContext);
        }
        StafParser.Variable_referenceContext variableReferenceContext = ctx.variable_reference();
        if (variableReferenceContext != null) {
            return new VariableReferenceVisitor().visitVariable_reference(variableReferenceContext);
        }
        StafParser.ListLiteralContext listLiteralContext = ctx.listLiteral();
        if (listLiteralContext != null) {
            return new ListLiteralVisitor().visitListLiteral(listLiteralContext);
        }
        StafParser.DictionaryLiteralContext dictionaryLiteralContext = ctx.dictionaryLiteral();
        if (dictionaryLiteralContext != null) {
            return new DictionaryLiteralVisitor().visitDictionaryLiteral(dictionaryLiteralContext);
        }
        StafParser.Keyword_callContext keywordCallContext = ctx.keyword_call();
        if (keywordCallContext != null) {
            return new KeywordCallVisitor().visitKeyword_call(keywordCallContext);
        }
        return super.visitObject(ctx);
    }
}
