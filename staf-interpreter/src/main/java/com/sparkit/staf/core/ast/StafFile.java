package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.parser.SyntaxError;
import com.sparkit.staf.core.runtime.interpreter.SemanticError;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class StafFile {
    private String suiteName;
    private String filePath;
    private List<ImportStatement> imports;
    private Map<String, Assignment> variableDeclarationMap;
    private List<KeywordDeclaration> keywordDeclarations;
    private Map<String, TestCaseDeclaration> testCaseDeclarationMap;
    private List<SyntaxError> syntaxErrors = new ArrayList<>();
    private List<SemanticError> semanticErrors = new ArrayList<>();
}
