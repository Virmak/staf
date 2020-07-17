package com.sparkit.staf.core.ast;

public enum ExpressionOperator {
    PLUS("+"),
    MINUS("-"),
    MUL("*"),
    DIV("/"),
    MOD("%"),
    EQUAL("=="),
    GT(">"),
    LT("<"),
    GTE(">="),
    LTE("<="),
    NE("!="),
    AND("AND"),
    OR("OR"),
    ;

    private final String text;

    ExpressionOperator(String op) {
        this.text = op;
    }

    public static ExpressionOperator fromString(String operation) {
        for (ExpressionOperator op : ExpressionOperator.values()) {
            if (op.text.equalsIgnoreCase(operation)) {
                return op;
            }
        }
        return null;
    }
}
