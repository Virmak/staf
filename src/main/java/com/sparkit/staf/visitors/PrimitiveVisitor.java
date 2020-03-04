package com.sparkit.staf.visitors;

import com.sparkit.staf.ast.types.StafBoolean;
import com.sparkit.staf.ast.types.StafInteger;
import com.sparkit.staf.ast.types.StafString;
import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.ast.types.AbstractStafObject;
import com.sparkit.staf.ast.StafTypes;

public class PrimitiveVisitor extends StafBaseVisitor<AbstractStafObject> {

    @Override
    public AbstractStafObject visitPrimitive(StafParser.PrimitiveContext ctx) {
        AbstractStafObject obj = null;
        StafParser.NumberContext numberContext = ctx.number();
        StafParser.BoolContext boolContext = ctx.bool();
        StafParser.StringContext str = ctx.string();
        if (numberContext != null) {
            obj = new StafInteger(Integer.parseInt(numberContext.getText()));
        } else if (boolContext != null) {
            obj = new StafBoolean(boolContext.getText().toLowerCase().equals("true"));
        } else if (str != null) {
            obj = new StafString(str.getText().replaceAll("\"", "").replaceAll("'", ""));
        }
        return obj;
    }
}
