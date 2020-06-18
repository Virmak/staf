package com.sparkit.staf.core.visitors;

import com.sparkit.staf.core.parser.StafBaseVisitor;
import com.sparkit.staf.core.parser.StafParser;
import com.sparkit.staf.core.ast.TestCaseDeclaration;
import org.antlr.v4.runtime.tree.ParseTree;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public class TestCaseDeclarationVisitor extends StafBaseVisitor<TestCaseDeclaration> {
    @Autowired
    private TestCaseBodyVisitor testCaseBodyVisitor;
    private int testCaseDefaultOrder = 100;
    @Override
    public TestCaseDeclaration visitTest_case_declaration(StafParser.Test_case_declarationContext ctx) {
        TestCaseDeclaration testCaseDeclaration = new TestCaseDeclaration();
        for (StafParser.Test_case_beforeContext testCaseBeforeContext : ctx.test_case_before()) {

        }
        StafParser.Test_case_priorityContext priorityContext = ctx.test_case_priority();
        if (priorityContext != null) {
            if (priorityContext.INT() != null) {
                int order = Integer.parseInt(priorityContext.INT().getText());
                testCaseDeclaration.setOrder(order);
            } else if (priorityContext.IGNORE() != null) {
                testCaseDeclaration.setIgnored(true);
            }
        } else {
            testCaseDeclaration.setOrder(testCaseDefaultOrder++);
        }
        String testCaseNameWithSpaces = ctx.keyword_name().IDENTIFIER().stream().map(ParseTree::getText)
                .collect(Collectors.joining(" "));
        testCaseDeclaration.setName(testCaseNameWithSpaces);
        StafParser.Test_case_bodyContext bodyContext = ctx.test_case_body();
        testCaseDeclaration.setStatements(testCaseBodyVisitor.visitTest_case_body(bodyContext));
        return testCaseDeclaration;
    }
}
