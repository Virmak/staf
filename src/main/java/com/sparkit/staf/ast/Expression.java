package com.sparkit.staf.ast;

import com.sparkit.staf.ast.types.*;
import com.sparkit.staf.runtime.ExpressionEvaluator;
import com.sparkit.staf.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;

public class Expression extends AbstractStafObject {
    protected AbstractStafObject left;
    protected AbstractStafObject right;
    protected ExpressionOps operation;
    protected boolean inverted; // tell if expr is inverted like - minus or ! not for booleans

    public Expression() {
    }

    public Expression(AbstractStafObject left, AbstractStafObject right, ExpressionOps operation) {
        this.left = left;
        this.right = right;
        this.operation = operation;
        this.type = StafTypes.EXPRESSION;
    }

    public boolean isInverted() {
        return inverted;
    }

    public void setInverted(boolean inverted) {
        this.inverted = inverted;
    }

    public AbstractStafObject getLeft() {
        return left;
    }

    public void setLeft(AbstractStafObject left) {
        this.left = left;
    }

    public AbstractStafObject getRight() {
        return right;
    }

    public void setRight(AbstractStafObject right) {
        this.right = right;
    }

    public ExpressionOps getOperation() {
        return operation;
    }

    public void setOperation(ExpressionOps operation) {
        this.operation = operation;
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
    public Object evaluate(SymbolsTable globalSymTable, SymbolsTable localSymTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Exception {
        if (left instanceof Expression || left instanceof StafVariable) {
            left = (AbstractStafObject)left.evaluate(globalSymTable, localSymTable, keywordLibrariesRepository);
        }

        if (right instanceof Expression) {
            right = (AbstractStafObject)right.evaluate(globalSymTable, localSymTable, keywordLibrariesRepository);
        }

        if (operation == ExpressionOps.EQUAL) {
            return new StafBoolean( left.getValue().toString().equals(right.getValue().toString()));
        } else if (operation == ExpressionOps.PLUS) {
           return ExpressionEvaluator.add(left, right);
        } else if (operation == ExpressionOps.MINUS) {
            return ExpressionEvaluator.substract(left, right);
        } else if (operation == ExpressionOps.MUL) {
            return ExpressionEvaluator.multiply(left, right);
        } else if (operation == ExpressionOps.DIV) {
            return ExpressionEvaluator.div(left, right);
        }
        throw new Exception("not implemented operation " + operation);
    }
}
