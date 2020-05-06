package com.sparkit.interpreter.compiler.visitors;

import com.sparkit.interpreter.compiler.ast.TestCaseDeclaration;
import com.sparkit.interpreter.compiler.parser.StafBaseVisitor;
import com.sparkit.interpreter.compiler.parser.StafParser;
import org.springframework.beans.factory.annotation.Autowired;

public class TestCaseDeclarationVisitor extends StafBaseVisitor<TestCaseDeclaration> {
    @Autowired
    private TestCaseBodyVisitor testCaseBodyVisitor;
    private int testCaseDefaultOrder = 100;
    @Override
    public TestCaseDeclaration visitTest_case_declaration(StafParser.Test_case_declarationContext ctx) {
        TestCaseDeclaration testCaseDeclaration = new TestCaseDeclaration();
        StafParser.Test_case_priorityContext priorityContext = ctx.test_case_priority();
        if (priorityContext != null) {
            int order = Integer.parseInt(priorityContext.INT().getText());
            testCaseDeclaration.setOrder(order);
        } else {
            testCaseDeclaration.setOrder(testCaseDefaultOrder++);
        }
        String testCaseName = ctx.keyword_name().getText();
        if (testCaseName.toLowerCase().equals("setup")) {
            testCaseDeclaration.setOrder(Integer.MIN_VALUE);
        } else if (testCaseName.toLowerCase().equals("teardown")) {
            testCaseDeclaration.setOrder(Integer.MAX_VALUE);
        }
        testCaseDeclaration.setName(testCaseName);
        StafParser.Test_case_bodyContext bodyContext = ctx.test_case_body();
        testCaseDeclaration.setStatements(testCaseBodyVisitor.visitTest_case_body(bodyContext));
        return testCaseDeclaration;
    }
}
