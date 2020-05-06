package com.sparkit.interpreter.compiler.ast;

import com.sparkit.interpreter.compiler.ast.statement.Assignment;
import com.sparkit.interpreter.compiler.ast.statement.ImportStatement;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class StafFile {
    private String suiteName;
    private String filePath;
    private List<ImportStatement> imports;
    private Map<String, Assignment> variableDeclarationMap;
    private Map<String, KeywordDeclaration> keywordDeclarationMap;
    private Map<String, TestCaseDeclaration> testCaseDeclarationMap;
}
