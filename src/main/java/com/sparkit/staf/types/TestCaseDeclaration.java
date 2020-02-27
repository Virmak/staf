package com.sparkit.staf.types;

import java.util.List;

public class TestCaseDeclaration {
    private String name;
    private List<AbstractStatement> statements;

    public TestCaseDeclaration(String name, List<AbstractStatement> statements) {
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

    public List<AbstractStatement> getStatements() {
        return statements;
    }

    public void setStatements(List<AbstractStatement> statements) {
        this.statements = statements;
    }
}
