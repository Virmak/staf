package com.sparkit.interpreter.compiler.ast.statement;


import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;

public class ExitLoopStatement implements IStatement {
    private AbstractStafObject condition;

    public ExitLoopStatement(AbstractStafObject condition) {
        this.condition = condition;
    }

    public ExitLoopStatement() {}

    public AbstractStafObject getCondition() {
        return condition;
    }
}
