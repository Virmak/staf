package com.sparkit.staf.visitors;

import com.sparkit.staf.ast.types.StafList;
import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.ast.types.AbstractStafObject;
import com.sparkit.staf.ast.StafTypes;

import java.util.ArrayList;
import java.util.List;

public class ListLiteralVisitor extends StafBaseVisitor<AbstractStafObject> {
    @Override
    public AbstractStafObject visitListLiteral(StafParser.ListLiteralContext ctx) {
        List<AbstractStafObject> objectList = new ArrayList<>();
        for (StafParser.ObjectContext objectContext: ctx.object()) {
            objectList.add(new StafObjectVisitor().visitObject(objectContext));
        }
        return new StafList(objectList);
    }
}
