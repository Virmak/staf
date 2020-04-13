package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.types.*;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;

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
            obj = new StafString(parseString(str.getText()));
        }
        return obj;
    }

    private String parseString(String str) {
        String quotation = String.valueOf(str.charAt(0));
        return str.replaceAll(quotation, "");
    }
}
