package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import com.sparkit.staf.core.ast.KeyValuePair;

public class KeyValuePairVisitor extends StafBaseVisitor<KeyValuePair> {
    @Override
    public KeyValuePair visitKeyValuePair(StafParser.KeyValuePairContext ctx) {
        KeyValuePair keyValuePair = new KeyValuePair();

        StafParser.StringContext stringContext = ctx.string();
        if (stringContext != null) {
            keyValuePair.setKey(stringContext.getText().replaceAll("\"", "").replaceAll("'", ""));
        } else {
            keyValuePair.setKey(ctx.IDENTIFIER().getText());
        }
        keyValuePair.setValue(new StafObjectVisitor().visitObject(ctx.object()));
        return keyValuePair;
    }
}
