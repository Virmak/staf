package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.types.StafObject;

public class DictionaryLiteralVisitor extends StafBaseVisitor<StafObject> {
    @Override
    public StafObject visitDictionaryLiteral(StafParser.DictionaryLiteralContext ctx) {
        return super.visitDictionaryLiteral(ctx);
    }
}
