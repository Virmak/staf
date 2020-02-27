package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.types.TestCaseDeclaration;

import java.util.HashMap;
import java.util.Map;

public class TestCaseDeclarationsSectionVisitor extends StafBaseVisitor<Map<String, TestCaseDeclaration>> {

    @Override
    public Map<String, TestCaseDeclaration> visitTest_cases_section(StafParser.Test_cases_sectionContext ctx) {
        Map<String, TestCaseDeclaration> testCaseDeclarationMap = new HashMap<>();
        for (StafParser.Test_case_declarationContext testCaseDeclarationContext : ctx.test_case_declaration()) {
            TestCaseDeclaration testCaseDeclaration = new TestCaseDeclarationVisitor().visitTest_case_declaration(testCaseDeclarationContext);
            testCaseDeclarationMap.put(testCaseDeclaration.getName(), testCaseDeclaration);
        }
        return testCaseDeclarationMap;
    }
}
