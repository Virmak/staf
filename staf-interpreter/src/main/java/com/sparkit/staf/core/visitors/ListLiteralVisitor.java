package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.types.StafList;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ListLiteralVisitor extends StafBaseVisitor<AbstractStafObject> {
    @Autowired
    private StafObjectVisitor stafObjectVisitor;
    @Override
    public AbstractStafObject visitListLiteral(StafParser.ListLiteralContext ctx) {
        List<AbstractStafObject> objectList = new ArrayList<>();
        for (StafParser.ObjectContext objectContext: ctx.object()) {
            objectList.add(stafObjectVisitor.visitObject(objectContext));
        }
        return new StafList(objectList);
    }
}
