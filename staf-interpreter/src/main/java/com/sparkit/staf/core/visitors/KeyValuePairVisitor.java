package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.KeyValuePair;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

public class KeyValuePairVisitor extends StafBaseVisitor<KeyValuePair> {
    @Autowired
    private StafObjectVisitor stafObjectVisitor;

    @Override
    public KeyValuePair visitKeyValuePair(StafParser.KeyValuePairContext ctx) {
        KeyValuePair keyValuePair = new KeyValuePair();

        StafParser.StringContext stringContext = ctx.string();
        if (stringContext != null) {
            keyValuePair.setKey(stringContext.getText().replaceAll("\"", "").replaceAll("'", ""));
        } else {
            keyValuePair.setKey(ctx.IDENTIFIER().getText());
        }
        keyValuePair.setValue(stafObjectVisitor.visitObject(ctx.object()));
        return keyValuePair;
    }
}
