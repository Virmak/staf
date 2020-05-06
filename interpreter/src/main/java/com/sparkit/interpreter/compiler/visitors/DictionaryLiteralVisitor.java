package com.sparkit.interpreter.compiler.visitors;


import com.sparkit.interpreter.compiler.ast.KeyValuePair;
import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.compiler.ast.types.StafDictionary;
import com.sparkit.interpreter.compiler.parser.StafBaseVisitor;
import com.sparkit.interpreter.compiler.parser.StafParser;
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
