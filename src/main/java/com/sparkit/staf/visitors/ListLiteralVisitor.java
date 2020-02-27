package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.ast.StafObject;
import com.sparkit.staf.ast.StafTypes;

import java.util.ArrayList;
import java.util.List;

public class ListLiteralVisitor extends StafBaseVisitor<StafObject> {
    @Override
    public StafObject visitListLiteral(StafParser.ListLiteralContext ctx) {
        List<StafObject> objectList = new ArrayList<>();
        for (StafParser.ObjectContext objectContext: ctx.object()) {
            objectList.add(new StafObjectVisitor().visitObject(objectContext));
        }
        return new StafObject(objectList, StafTypes.LIST);
    }
}
