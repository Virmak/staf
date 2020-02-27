package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.ast.StafObject;

import java.util.ArrayList;
import java.util.List;

public class KeywordCallArgumentsVisitor extends StafBaseVisitor<List<StafObject>> {
    @Override
    public List<StafObject> visitKeyword_call_arguments(StafParser.Keyword_call_argumentsContext ctx) {
        List<StafObject> objectList = new ArrayList<>();
        if (ctx.object() != null) {
            for (StafParser.ObjectContext objectContext: ctx.object()) {
                objectList.add(new StafObjectVisitor().visitObject(objectContext));
            }
        }
        return objectList;
    }
}
