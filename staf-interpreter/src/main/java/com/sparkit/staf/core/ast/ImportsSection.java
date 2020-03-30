package com.sparkit.staf.core.ast;

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
