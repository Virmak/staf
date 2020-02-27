package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.types.KeyValuePair;
import com.sparkit.staf.types.StafObject;
import com.sparkit.staf.types.StafTypes;

import java.util.HashMap;
import java.util.Map;

public class DictionaryLiteralVisitor extends StafBaseVisitor<StafObject> {
    @Override
    public StafObject visitDictionaryLiteral(StafParser.DictionaryLiteralContext ctx) {
        Map<String, StafObject> dict = new HashMap<>();
        for (StafParser.KeyValuePairContext keyValuePairContext: ctx.keyValuePair()) {
            KeyValuePair keyValuePair = new KeyValuePairVisitor().visitKeyValuePair(keyValuePairContext);
            dict.put(keyValuePair.getKey(), keyValuePair.getValue());
        }
        return new StafObject(dict, StafTypes.DICTIONARY);
    }
}
