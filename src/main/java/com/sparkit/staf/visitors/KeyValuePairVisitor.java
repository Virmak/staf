package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.types.KeyValuePair;

public class KeyValuePairVisitor extends StafBaseVisitor<KeyValuePair> {
    @Override
    public KeyValuePair visitKeyValuePair(StafParser.KeyValuePairContext ctx) {
        KeyValuePair keyValuePair = new KeyValuePair();

        StafParser.StringContext stringContext = ctx.string();
        if (stringContext != null) {
            keyValuePair.setKey(stringContext.getText());
        } else {
            keyValuePair.setKey(ctx.IDENTIFIER().getText());
        }


        return super.visitKeyValuePair(ctx);
    }
}
