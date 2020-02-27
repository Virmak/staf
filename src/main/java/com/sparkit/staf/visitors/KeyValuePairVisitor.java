package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.types.KeyValuePair;
import com.sparkit.staf.types.StafObject;

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
