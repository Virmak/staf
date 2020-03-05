package com.sparkit.staf.visitors;

import com.sparkit.staf.ast.types.*;
import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.ast.StafTypes;

public class PrimitiveVisitor extends StafBaseVisitor<AbstractStafObject> {

    @Override
    public AbstractStafObject visitPrimitive(StafParser.PrimitiveContext ctx) {
        AbstractStafObject obj = null;
        StafParser.NumberContext numberContext = ctx.number();
        StafParser.BoolContext boolContext = ctx.bool();
        StafParser.StringContext str = ctx.string();
        if (numberContext != null) {
            if (numberContext.INT().getText() != null) {
                obj = new StafInteger(Integer.parseInt(numberContext.getText()));
            } else {
                obj = new StafDouble(Double.parseDouble(numberContext.getText()));
            }
        } else if (boolContext != null) {
            obj = new StafBoolean(boolContext.getText().toLowerCase().equals("true"));
        } else if (str != null) {
            obj = new StafString(str.getText().replaceAll("\"", "").replaceAll("'", ""));
        }
        return obj;
    }
}
