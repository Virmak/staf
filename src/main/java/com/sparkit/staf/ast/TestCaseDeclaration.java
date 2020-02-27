package com.sparkit.staf.ast;

import java.util.List;

public class TestCaseDeclaration {
    private String name;
    private List<IStatement> statements;

    public TestCaseDeclaration(String name, List<IStatement> statements) {
        this.name = name;
        this.statements = statements;
    }

    public TestCaseDeclaration() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IStatement> getStatements() {
        return statements;
    }

    public void setStatements(List<IStatement> statements) {
        this.statements = statements;
    }
}
