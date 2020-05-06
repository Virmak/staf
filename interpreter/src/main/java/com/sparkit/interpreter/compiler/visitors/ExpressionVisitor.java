package com.sparkit.interpreter.compiler.visitors;


import com.sparkit.interpreter.compiler.ast.Expression;
import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.compiler.ast.types.StafBoolean;
import com.sparkit.interpreter.compiler.ast.types.StafInteger;
import com.sparkit.interpreter.compiler.parser.StafBaseVisitor;
import com.sparkit.interpreter.compiler.parser.StafParser;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.springframework.beans.factory.annotation.Autowired;

public class ExpressionVisitor extends StafBaseVisitor<AbstractStafObject> {
    @Autowired
    private ScalarObjectVisitor scalarObjectVisitor;

    @Override
    public AbstractStafObject visitExpression(StafParser.ExpressionContext ctx) {
        TerminalNode minus = ctx.MINUS();
        TerminalNode not = ctx.NOT();
        if (minus != null || not != null) {
            AbstractStafObject obj = visitExpression(ctx.expression(0));
            if (obj instanceof Expression) {
                ((Expression)obj).setInverted(true);
            } else if (obj instanceof StafInteger) {
                obj.setValue( -(int)obj.getValue());
            } else if (obj instanceof StafBoolean) {
                obj.setValue(!(boolean)obj.getValue());
            }
            return obj;
        }
        TerminalNode leftParen = ctx.LPARENT();
        TerminalNode rightParen = ctx.RPARENT();
        if (leftParen != null) {
            return visitExpression(ctx.expression(0));
        }

        StafParser.ExpressionContext leftExpressionContext = ctx.expression(0);
        if (leftExpressionContext != null) {
            Expression e = new Expression();
            e.setLeft(visitExpression(leftExpressionContext));
            StafParser.MulopContext mulopContext = ctx.mulop();
            if (mulopContext != null) {
                e.setOperation(mulopContext.getText());
            }
            StafParser.AddopContext addopContext = ctx.addop();
            if (addopContext != null) {
                e.setOperation(addopContext.getText());
            }
            StafParser.BinopContext binopContext = ctx.binop();
            if (binopContext != null) {
                e.setOperation(binopContext.getText());
            }

            e.setRight(visitExpression(ctx.expression(1)));
            return e;
        }
        StafParser.Scalar_objectContext scalarObjectContext = ctx.scalar_object();
        if (scalarObjectContext != null) {
            return scalarObjectVisitor.visitScalar_object(ctx.scalar_object());
        }
        return super.visitExpression(ctx);
    }
}
