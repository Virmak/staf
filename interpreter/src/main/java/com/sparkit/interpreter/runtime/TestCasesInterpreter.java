package com.sparkit.interpreter.runtime;

import com.sparkit.interpreter.compiler.ast.TestCaseDeclaration;
import com.sparkit.interpreter.compiler.ast.statement.IStatement;
import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.runtime.evaluator.statement.IStatementExecutor;
import com.sparkit.staf.domain.TestResult;
import com.sparkit.staf.domain.report.TestCaseReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Component
public class TestCasesInterpreter {
    @Autowired
    private CallStack callStack;
    @Autowired
    private IStatementExecutor<IStatement, AbstractStafObject> statementExecutor;

    public TestCaseReport execute(TestCaseDeclaration testCase) {
        SymbolsTable localSymTable = new SymbolsTable();
        TestCaseReport testCaseReport = createTestCaseReport(testCase.getName());
        callStack.push(testCase);
        for (IStatement statement : testCase.getStatements()) {
            try {
                statementExecutor.execute(statement, localSymTable);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                testCaseReport.setResult(TestResult.Fail);
                testCaseReport.setErrorMessage(throwable.getMessage());
            }
        }
        callStack.pop();
        return testCaseReport;
    }

    public void sortTestCasesByOrder(List<TestCaseDeclaration> testCaseDeclarationList) {
        Collections.sort(
                testCaseDeclarationList, new Comparator<TestCaseDeclaration>() {
                    @Override
                    public int compare(TestCaseDeclaration t1,
                                       TestCaseDeclaration t2) {
                        return t1.getOrder() - t2.getOrder();
                    }
                }
        );
    }

    private TestCaseReport createTestCaseReport(String testCaseName) {
        TestCaseReport testCaseReport = new TestCaseReport();
        testCaseReport.setStart(new Date());
        testCaseReport.setTestCase(testCaseName);
        testCaseReport.setResult(TestResult.Pass);
        return testCaseReport;
    }
}
