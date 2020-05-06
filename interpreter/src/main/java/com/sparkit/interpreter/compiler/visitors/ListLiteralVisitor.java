package com.sparkit.interpreter.compiler.visitors;


import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.compiler.ast.types.StafList;
import com.sparkit.interpreter.compiler.parser.StafBaseVisitor;
import com.sparkit.interpreter.compiler.parser.StafParser;
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
