package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.parser.SyntaxError;
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
    private List<SyntaxError> syntaxErrors;
}
