package com.sparkit.staf.visitors;

import com.sparkit.staf.ast.types.StafDictionary;
import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.ast.KeyValuePair;
import com.sparkit.staf.ast.types.AbstractStafObject;

import java.util.HashMap;
import java.util.Map;

public class DictionaryLiteralVisitor extends StafBaseVisitor<AbstractStafObject> {
    @Override
    public AbstractStafObject visitDictionaryLiteral(StafParser.DictionaryLiteralContext ctx) {
        Map<String, AbstractStafObject> dict = new HashMap<>();
        for (StafParser.KeyValuePairContext keyValuePairContext: ctx.keyValuePair()) {
            KeyValuePair keyValuePair = new KeyValuePairVisitor().visitKeyValuePair(keyValuePairContext);
            // check if key already exist and throw an error
            dict.put(keyValuePair.getKey(), keyValuePair.getValue());
        }
        return new StafDictionary(dict);
    }
}
