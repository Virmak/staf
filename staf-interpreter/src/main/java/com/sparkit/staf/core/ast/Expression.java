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
    private ExpressionOperator operation;
    private boolean inverted; // tell if expr is inverted like - minus or boolean not (!)

    @Autowired
    private ExpressionEvaluatorFactory expressionEvaluatorFactory;

    public Expression(AbstractStafObject left, AbstractStafObject right, ExpressionOperator operation) {
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
                this.operation = ExpressionOperator.PLUS;
                break;
            case "-":
                this.operation = ExpressionOperator.MINUS;
                break;
            case "*":
                this.operation = ExpressionOperator.MUL;
                break;
            case "/":
                this.operation = ExpressionOperator.DIV;
                break;
            case "%":
                this.operation = ExpressionOperator.MOD;
                break;
            case "==":
                this.operation = ExpressionOperator.EQUAL;
                break;
            case "!=":
                this.operation = ExpressionOperator.NE;
                break;
            case ">=":
                this.operation = ExpressionOperator.GTE;
                break;
            case "<=":
                this.operation = ExpressionOperator.LTE;
                break;
            case ">":
                this.operation = ExpressionOperator.GT;
                break;
            case "<":
                this.operation = ExpressionOperator.LT;
                break;
            case "AND":
                this.operation = ExpressionOperator.AND;
                break;
            case "OR":
                this.operation = ExpressionOperator.OR;
                break;
        }
    }

    @Override
    public Object evaluate(SymbolsTable globalSymbolsTable, SymbolsTable localSymbolsTable) throws Throwable {
        AbstractStafObject expressionLeftMemberValue = expressionLeftMember;
        AbstractStafObject expressionRightMemberValue = expressionRightMember;
        if (expressionLeftMember instanceof Expression || expressionLeftMember instanceof StafVariable || expressionLeftMember instanceof DictionaryItemAccess
                || expressionLeftMember instanceof ListItemAccess) {
            expressionLeftMemberValue = (AbstractStafObject) expressionLeftMember.evaluate(globalSymbolsTable, localSymbolsTable);
        }
        if (expressionRightMember instanceof Expression || expressionRightMember instanceof StafVariable || expressionRightMember instanceof DictionaryItemAccess
                || expressionRightMember instanceof ListItemAccess) {
            expressionRightMemberValue = (AbstractStafObject) expressionRightMember.evaluate(globalSymbolsTable, localSymbolsTable);
        }
        ExpressionEvaluator expressionEvaluator = expressionEvaluatorFactory.getExpressionEvaluator(operation);
        return expressionEvaluator.evaluate(expressionLeftMemberValue, expressionRightMemberValue, operation);
    }
}
