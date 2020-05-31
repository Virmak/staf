package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.ast.types.*;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.interpreter.expression.ExpressionEvaluatorO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.naming.OperationNotSupportedException;

@EqualsAndHashCode(callSuper = true)
@Data
public class Expression extends AbstractStafObject {
    private AbstractStafObject expressionLeftMember;
    private AbstractStafObject expressionRightMember;
    private ExpressionOps operation;
    private boolean inverted; // tell if expr is inverted like - minus or ! not for booleans

    public Expression() {
    }

    public Expression(AbstractStafObject left, AbstractStafObject right, ExpressionOps operation) {
        this.expressionLeftMember = left;
        this.expressionRightMember = right;
        this.operation = operation;
        this.type = StafTypes.EXPRESSION;
    }

    public void setExpressionLeftMember(AbstractStafObject expressionLeftMember) {
        this.expressionLeftMember = expressionLeftMember;
    }

    public void setExpressionRightMember(AbstractStafObject expressionRightMember) {
        this.expressionRightMember = expressionRightMember;
    }

    public ExpressionOps getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        switch (operation) {
            case "+":
                this.operation = ExpressionOps.PLUS;
                break;
            case "-":
                this.operation = ExpressionOps.MINUS;
                break;
            case "*":
                this.operation = ExpressionOps.MUL;
                break;
            case "/":
                this.operation = ExpressionOps.DIV;
                break;
            case "%":
                this.operation = ExpressionOps.MOD;
                break;
            case "==":
                this.operation = ExpressionOps.EQUAL;
                break;
            case "!=":
                this.operation = ExpressionOps.NE;
                break;
            case ">=":
                this.operation = ExpressionOps.GTE;
                break;
            case "<=":
                this.operation = ExpressionOps.LTE;
                break;
            case ">":
                this.operation = ExpressionOps.GT;
                break;
            case "<":
                this.operation = ExpressionOps.LT;
                break;
            case "AND":
                this.operation = ExpressionOps.AND;
                break;
            case "OR":
                this.operation = ExpressionOps.OR;
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

        switch (operation) {
            case EQUAL:
                return new StafBoolean(expressionLeftMemberValue.getValue().toString().equals(expressionRightMemberValue.getValue().toString()));
            case PLUS:
                return ExpressionEvaluatorO.add(expressionLeftMemberValue, expressionRightMemberValue);
            case MINUS:
                return ExpressionEvaluatorO.subtract(expressionLeftMemberValue, expressionRightMemberValue);
            case MUL:
                return ExpressionEvaluatorO.multiply(expressionLeftMemberValue, expressionRightMemberValue);
            case DIV:
                return ExpressionEvaluatorO.div(expressionLeftMemberValue, expressionRightMemberValue);
            case GT:
                return ExpressionEvaluatorO.greaterThan(expressionLeftMemberValue, expressionRightMemberValue);
            case LT:
                return ExpressionEvaluatorO.lessThan(expressionLeftMemberValue, expressionRightMemberValue);
            case GTE:
                return ExpressionEvaluatorO.greaterThanOrEqual(expressionLeftMemberValue, expressionRightMemberValue);
            case LTE:
                return ExpressionEvaluatorO.lessThanOrEqual(expressionLeftMemberValue, expressionRightMemberValue);
            case NE:
                return ExpressionEvaluatorO.notEqual(expressionLeftMemberValue, expressionRightMemberValue);
        }
        throw new OperationNotSupportedException();
    }
}
