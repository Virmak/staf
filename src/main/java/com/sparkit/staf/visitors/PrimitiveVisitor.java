package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.types.StafObject;
import com.sparkit.staf.types.StafTypes;

public class PrimitiveVisitor extends StafBaseVisitor<StafObject> {

    @Override
    public StafObject visitPrimitive(StafParser.PrimitiveContext ctx) {
        StafObject obj = null;
        StafParser.NumberContext numberContext = ctx.number();
        StafParser.BoolContext boolContext = ctx.bool();
        StafParser.StringContext str = ctx.string();
        if (numberContext != null) {
            obj = new StafObject(Integer.parseInt(numberContext.getText()), StafTypes.INT);
        } else if (boolContext != null) {
            obj = new StafObject(boolContext.getText().toLowerCase().equals("true"), StafTypes.BOOL);
        } else if (str != null) {
            obj = new StafObject(str, StafTypes.STRING);
        }
        return obj;
    }
}
