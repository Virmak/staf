package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import com.sparkit.staf.core.ast.TestCaseDeclaration;
import org.springframework.beans.factory.annotation.Autowired;

public class TestCaseDeclarationVisitor extends StafBaseVisitor<TestCaseDeclaration> {
    @Autowired
    private TestCaseBodyVisitor testCaseBodyVisitor;
    @Override
    public TestCaseDeclaration visitTest_case_declaration(StafParser.Test_case_declarationContext ctx) {
        TestCaseDeclaration testCaseDeclaration = new TestCaseDeclaration();
        testCaseDeclaration.setName(ctx.keyword_name().getText());
        StafParser.Test_case_bodyContext bodyContext = ctx.test_case_body();
        testCaseDeclaration.setStatements(testCaseBodyVisitor.visitTest_case_body(bodyContext));
        return testCaseDeclaration;
    }
}
