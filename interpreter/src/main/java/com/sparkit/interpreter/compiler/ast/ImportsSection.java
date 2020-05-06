package com.sparkit.interpreter.compiler.ast;

import com.sparkit.interpreter.compiler.ast.statement.ImportStatement;

import java.util.ArrayList;
import java.util.List;

public class ImportsSection {
    private List<ImportStatement> importStatementList;

    public ImportsSection() {
        importStatementList = new ArrayList<>();
    }

    public ImportsSection(List<ImportStatement> importStatementList) {
        this.importStatementList = importStatementList;
    }

    public List<ImportStatement> getImportStatementList() {
        return importStatementList;
    }

    public void setImportStatementList(List<ImportStatement> importStatementList) {
        this.importStatementList = importStatementList;
    }
}
