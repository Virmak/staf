package com.sparkit.staf.ast;

import java.util.List;
import java.util.Map;

public class StafFile {
    private String suiteName;
    private List<ImportStatement> imports;
    private Map<String, Assignment> variableDeclarationMap;
    private Map<String, KeywordDeclaration> keywordDeclarationMap;
    private Map<String, TestCaseDeclaration> testCaseDeclarationMap;

    public StafFile() {
    }

    public StafFile(
            String suiteName, List<ImportStatement> imports,
            Map<String, Assignment> variableDeclarationMap,
            Map<String, KeywordDeclaration> keywordDeclarationMap,
            Map<String, TestCaseDeclaration> testCaseDeclarationMap) {
        this.suiteName = suiteName;
        this.imports = imports;
        this.variableDeclarationMap = variableDeclarationMap;
        this.keywordDeclarationMap = keywordDeclarationMap;
        this.testCaseDeclarationMap = testCaseDeclarationMap;
    }

    public String getSuiteName() {
        return suiteName;
    }

    public void setSuiteName(String suiteName) {
        this.suiteName = suiteName;
    }

    public List<ImportStatement> getImports() {
        return imports;
    }

    public void setImports(List<ImportStatement> imports) {
        this.imports = imports;
    }

    public Map<String, Assignment> getVariableDeclarationMap() {
        return variableDeclarationMap;
    }

    public void setVariableDeclarationMap(Map<String, Assignment> variableDeclarationMap) {
        this.variableDeclarationMap = variableDeclarationMap;
    }

    public Map<String, KeywordDeclaration> getKeywordDeclarationMap() {
        return keywordDeclarationMap;
    }

    public void setKeywordDeclarationMap(Map<String, KeywordDeclaration> keywordDeclarationMap) {
        this.keywordDeclarationMap = keywordDeclarationMap;
    }

    public Map<String, TestCaseDeclaration> getTestCaseDeclarationMap() {
        return testCaseDeclarationMap;
    }

    public void setTestCaseDeclarationMap(Map<String, TestCaseDeclaration> testCaseDeclarationMap) {
        this.testCaseDeclarationMap = testCaseDeclarationMap;
    }
}
