package com.sparkit.staf.visitors;

import com.sparkit.staf.parser.StafBaseVisitor;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.ast.TestCaseDeclaration;

public class TestCaseDeclarationVisitor extends StafBaseVisitor<TestCaseDeclaration> {
    @Override
    public TestCaseDeclaration visitTest_case_declaration(StafParser.Test_case_declarationContext ctx) {
        TestCaseDeclaration testCaseDeclaration = new TestCaseDeclaration();
        testCaseDeclaration.setName(ctx.keyword_name().getText());
        StafParser.Test_case_bodyContext bodyContext = ctx.test_case_body();
        testCaseDeclaration.setStatements(new TestCaseBodyVisitor().visitTest_case_body(bodyContext));
        return testCaseDeclaration;
    }
}
