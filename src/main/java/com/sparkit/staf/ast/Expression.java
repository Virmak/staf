package com.sparkit.staf.ast;

import com.sparkit.staf.ast.types.AbstractStafObject;
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
        }
    }

    @Override
    public Object evaluate(SymbolsTable globalSymTable, SymbolsTable localSymTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Exception {
        throw new Exception("not implemented");
    }
}
