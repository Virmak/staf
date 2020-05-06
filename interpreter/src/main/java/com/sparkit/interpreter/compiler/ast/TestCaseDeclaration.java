package com.sparkit.interpreter.compiler.ast;

import com.sparkit.interpreter.compiler.ast.statement.IStatement;
import com.sparkit.interpreter.compiler.ast.statement.StafCallable;
import lombok.Data;

import java.util.List;

@Data
public class TestCaseDeclaration implements StafCallable {
    private String name;
    private List<IStatement> statements;
    private int order;
    private static int instanceCount;

    public TestCaseDeclaration(String name, List<IStatement> statements) {
        this.name = name;
        this.statements = statements;
    }

    public TestCaseDeclaration() {
    }

}
