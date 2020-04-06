package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.ast.TestCaseDeclaration;
import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class TestCaseDeclarationsSectionVisitor extends StafBaseVisitor<Map<String, TestCaseDeclaration>> {
    @Autowired
    private TestCaseDeclarationVisitor testCaseDeclarationVisitor;

    @Override
    public Map<String, TestCaseDeclaration> visitTest_cases_section(StafParser.Test_cases_sectionContext ctx) {
        Map<String, TestCaseDeclaration> testCaseDeclarationMap = new HashMap<>();
        for (StafParser.Test_case_declarationContext testCaseDeclarationContext : ctx.test_case_declaration()) {
            TestCaseDeclaration testCaseDeclaration = testCaseDeclarationVisitor.visitTest_case_declaration(testCaseDeclarationContext);
            testCaseDeclarationMap.put(testCaseDeclaration.getName().toLowerCase(), testCaseDeclaration);
        }
        return testCaseDeclarationMap;
    }
}
