package com.sparkit.staf.core.ast;

import lombok.Data;

import java.util.List;

@Data
public class TestCaseDeclaration {
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
