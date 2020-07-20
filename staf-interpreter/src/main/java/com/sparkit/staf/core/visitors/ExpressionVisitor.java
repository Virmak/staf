package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.Expression;
import com.sparkit.staf.core.ast.ExpressionOperator;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.StafBoolean;
import com.sparkit.staf.core.ast.types.StafInteger;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import com.sparkit.staf.core.runtime.interpreter.expression.ExpressionEvaluatorFactory;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.springframework.beans.factory.annotation.Autowired;

public class ExpressionVisitor extends StafBaseVisitor<AbstractStafObject> {
    @Autowired
    private ScalarObjectVisitor scalarObjectVisitor;
    @Autowired
    private ExpressionEvaluatorFactory expressionEvaluatorFactory;

    @Override
    public AbstractStafObject visitExpression(StafParser.ExpressionContext ctx) {
        TerminalNode minusNode = ctx.MINUS();
        TerminalNode notNode = ctx.NOT();
        if (minusNode != null || notNode != null) {
            AbstractStafObject stafObject = visitExpression(ctx.expression(0));
            if (stafObject instanceof Expression) {
                ((Expression) stafObject).setInverted(true);
            } else if (stafObject instanceof StafInteger) {
                stafObject.setValue(-(int) stafObject.getValue());
            } else if (stafObject instanceof StafBoolean) {
                stafObject.setValue(!(boolean) stafObject.getValue());
            }
            return stafObject;
        }
        TerminalNode leftParen = ctx.LPARENT();
        TerminalNode rightParen = ctx.RPARENT();
        if (leftParen != null) {
            return visitExpression(ctx.expression(0));
        }

        StafParser.ExpressionContext leftExpressionContext = ctx.expression(0);
        if (leftExpressionContext != null) {
            Expression expression = new Expression(expressionEvaluatorFactory);
            expression.setExpressionLeftMember(visitExpression(leftExpressionContext));
            StafParser.MulopContext mulopContext = ctx.mulop();
            if (mulopContext != null) {
                expression.setOperation(ExpressionOperator.fromString(mulopContext.getText()));
            }
            StafParser.AddopContext addopContext = ctx.addop();
            if (addopContext != null) {
                expression.setOperation(ExpressionOperator.fromString(addopContext.getText()));
            }
            StafParser.BinopContext binopContext = ctx.binop();
            if (binopContext != null) {
                expression.setOperation(ExpressionOperator.fromString(binopContext.getText()));
            }

            expression.setExpressionRightMember(visitExpression(ctx.expression(1)));
            return expression;
        }
        StafParser.Scalar_objectContext scalarObjectContext = ctx.scalar_object();
        if (scalarObjectContext != null) {
            return scalarObjectVisitor.visitScalar_object(ctx.scalar_object());
        }
        return super.visitExpression(ctx);
    }
}
