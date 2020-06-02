package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.types.StafDictionary;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import com.sparkit.staf.core.ast.KeyValuePair;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class DictionaryLiteralVisitor extends StafBaseVisitor<AbstractStafObject> {
    @Autowired
    private KeyValuePairVisitor keyValuePairVisitor;
    @Override
    public AbstractStafObject visitDictionaryLiteral(StafParser.DictionaryLiteralContext ctx) {
        Map<String, AbstractStafObject> dict = new HashMap<>();
        for (StafParser.KeyValuePairContext keyValuePairContext: ctx.keyValuePair()) {
            KeyValuePair keyValuePair = keyValuePairVisitor.visitKeyValuePair(keyValuePairContext);
            // check if key already exist and throw an error
            dict.put(keyValuePair.getKey(), keyValuePair.getValue());
        }
        return new StafDictionary(dict);
    }
}
