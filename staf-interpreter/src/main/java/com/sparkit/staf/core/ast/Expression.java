package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.DictionaryItemAccess;
import com.sparkit.staf.core.ast.types.ListItemAccess;
import com.sparkit.staf.core.ast.types.StafVariable;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.interpreter.expression.ExpressionEvaluator;
import com.sparkit.staf.core.runtime.interpreter.expression.ExpressionEvaluatorFactory;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;

@EqualsAndHashCode(callSuper = true)
@Data
public class Expression extends AbstractStafObject {
    private AbstractStafObject expressionLeftMember;
    private AbstractStafObject expressionRightMember;
    private ExpressionOperators operation;
    private boolean inverted; // tell if expr is inverted like - minus or boolean not (!)

    @Autowired
    private ExpressionEvaluatorFactory expressionEvaluatorFactory;

    public Expression(AbstractStafObject left, AbstractStafObject right, ExpressionOperators operation) {
        this.expressionLeftMember = left;
        this.expressionRightMember = right;
        this.operation = operation;
        this.type = StafTypes.EXPRESSION;
    }

    public Expression(ExpressionEvaluatorFactory expressionEvaluatorFactory) {
        this.expressionEvaluatorFactory = expressionEvaluatorFactory;
        this.type = StafTypes.EXPRESSION;
    }

    public void setOperation(String operation) {
        switch (operation) {
            case "+":
                this.operation = ExpressionOperators.PLUS;
                break;
            case "-":
                this.operation = ExpressionOperators.MINUS;
                break;
            case "*":
                this.operation = ExpressionOperators.MUL;
                break;
            case "/":
                this.operation = ExpressionOperators.DIV;
                break;
            case "%":
                this.operation = ExpressionOperators.MOD;
                break;
            case "==":
                this.operation = ExpressionOperators.EQUAL;
                break;
            case "!=":
                this.operation = ExpressionOperators.NE;
                break;
            case ">=":
                this.operation = ExpressionOperators.GTE;
                break;
            case "<=":
                this.operation = ExpressionOperators.LTE;
                break;
            case ">":
                this.operation = ExpressionOperators.GT;
                break;
            case "<":
                this.operation = ExpressionOperators.LT;
                break;
            case "AND":
                this.operation = ExpressionOperators.AND;
                break;
            case "OR":
                this.operation = ExpressionOperators.OR;
                break;
        }
    }

    @Override
    public Object evaluate(SymbolsTable globalSymbolsTable, SymbolsTable localSymbolsTable) throws Throwable {
        if (expressionLeftMember instanceof Expression || expressionLeftMember instanceof StafVariable || expressionLeftMember instanceof DictionaryItemAccess
                || expressionLeftMember instanceof ListItemAccess) {
            expressionLeftMember = (AbstractStafObject) expressionLeftMember.evaluate(globalSymbolsTable, localSymbolsTable);
        }

        if (expressionRightMember instanceof Expression || expressionRightMember instanceof StafVariable || expressionRightMember instanceof DictionaryItemAccess
                || expressionRightMember instanceof ListItemAccess) {
            expressionRightMember = (AbstractStafObject) expressionRightMember.evaluate(globalSymbolsTable, localSymbolsTable);
        }
        ExpressionEvaluator expressionEvaluator = expressionEvaluatorFactory.getExpressionEvaluator(operation);
        return expressionEvaluator.evaluate(this);
    }
}
