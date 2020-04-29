package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.ast.types.*;
import com.sparkit.staf.core.runtime.interpreter.ExpressionEvaluator;
import com.sparkit.staf.core.runtime.interpreter.StatementBlockExecutor;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;

import javax.naming.OperationNotSupportedException;

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
    public Object evaluate(StatementBlockExecutor blockExecutor, SymbolsTable globalSymTable, SymbolsTable localSymTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        AbstractStafObject l = left;
        AbstractStafObject r = right;

        if (left instanceof Expression || left instanceof StafVariable || left instanceof DictionaryItemAccess
                || left instanceof ListItemAccess) {
            l = (AbstractStafObject)left.evaluate(blockExecutor, globalSymTable, localSymTable, keywordLibrariesRepository);
        }

        if (right instanceof Expression || right instanceof StafVariable || right instanceof DictionaryItemAccess
                || right instanceof ListItemAccess) {
            r = (AbstractStafObject)right.evaluate(blockExecutor, globalSymTable, localSymTable, keywordLibrariesRepository);
        }

        if (operation == ExpressionOps.EQUAL) {
            return new StafBoolean( l.getValue().toString().equals(r.getValue().toString()));
        } else if (operation == ExpressionOps.PLUS) {
           return ExpressionEvaluator.add(l, r);
        } else if (operation == ExpressionOps.MINUS) {
            return ExpressionEvaluator.subtract(l, r);
        } else if (operation == ExpressionOps.MUL) {
            return ExpressionEvaluator.multiply(l, r);
        } else if (operation == ExpressionOps.DIV) {
            return ExpressionEvaluator.div(l, r);
        } else if (operation == ExpressionOps.GT) {
            return ExpressionEvaluator.greaterThan(l, r);
        }else if (operation == ExpressionOps.LT) {
            return ExpressionEvaluator.lessThan(l, r);
        }else if (operation == ExpressionOps.GTE) {
            return ExpressionEvaluator.greaterThanOrEqual(l, r);
        }else if (operation == ExpressionOps.LTE) {
            return ExpressionEvaluator.lessThanOrEqual(l, r);
        }else if (operation == ExpressionOps.NE) {
            return ExpressionEvaluator.notEqual(l, r);
        }
        throw new OperationNotSupportedException();
    }
}
