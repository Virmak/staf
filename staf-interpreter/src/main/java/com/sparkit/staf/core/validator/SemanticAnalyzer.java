package com.sparkit.staf.core.validator;

import com.sparkit.staf.core.compiler.TestSuiteCompiler;
import com.sparkit.staf.core.ast.IStatement;
import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.ast.TestCaseDeclaration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class SemanticAnalyzer {
    private final TestSuiteCompiler testSuiteCompiler;

    @Autowired
    public SemanticAnalyzer(TestSuiteCompiler testSuiteCompiler) {
        this.testSuiteCompiler = testSuiteCompiler;
    }

    public void validateStafFile(StafFile stafFile) {

    }

    public void validateSemantics(Map<String, StafFile> fileMap) {
        fileMap.values().forEach(stafFile -> {
            List<IStatement> testCasesStatements = stafFile.getTestCaseDeclarationMap().values().stream()
                    .map(TestCaseDeclaration::getStatements)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
            validateStatementBlock(testCasesStatements);
        });
    }

    public void validateStatementBlock(List<IStatement> statements) {

    }
}
