package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.Main;
import com.sparkit.staf.core.ast.IStatement;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.KeywordCall;
import com.sparkit.staf.core.ast.types.StafList;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.reports.StatementReport;
import com.sparkit.staf.core.runtime.reports.TestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

@Component
public class StatementBlockExecutor {
    private static final Logger LOG = LogManager.getLogger(Main.class);
    private OnStatementFailed statementFailed;
    private Stack<KeywordCall> callStack = new Stack<>();

    public List<StatementReport> execute(IStatementBlock statementBlock,
                                         OnStatementFailed statementFailed,
                                         SymbolsTable globalSymTable,
                                         SymbolsTable localSymTable,
                                         KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        List<StatementReport> reports = new ArrayList<>();
        for (IStatement statement : statementBlock.getStatements()) {
            StatementReport statementReport = createStatementReport(statement, TestResult.Pass);
            try {
                statement.execute(this, globalSymTable, localSymTable, keywordLibrariesRepository);
                if (statement instanceof IStatementBlock) {
                    statementReport.setChildren(((IStatementBlock) statement).getStatementReports());
                }
                statementReport.setResult(TestResult.Pass);
            } catch (Exception e) {
                LOG.error("At " + statement);
                statementReport.setErrorMessage("At " + statement);
                statementReport.setResult(TestResult.Fail);
                if (this.statementFailed != null) {
                    this.statementFailed.execute(statementReport);
                }
            } finally {
                statementReport.setEnd(new Date());
            }
            reports.add(statementReport);
        }
        return reports;
    }

    public StatementReport executeIterable(IStafIterable iterable,
                                           SymbolsTable globalSymTable,
                                           SymbolsTable localSymTable,
                                           KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        StatementReport iterableReport = createStatementReport((IStatement) iterable, null);
        iterableReport.setChildren(new ArrayList<>());
        AbstractStafObject tmp = null;  // used to save variable with the same name as the loop variable if it currently
        // exist in localSymTable so we can retrieve it later after for statement execution
        if (localSymTable == null) {
            localSymTable = new SymbolsTable(this);
        } else {
            tmp = (AbstractStafObject) localSymTable.getSymbolValue(iterable.getVar().getValue().toString());
        }
        AbstractStafObject actualIterator = (AbstractStafObject) iterable.getIterator().evaluate(this, globalSymTable, localSymTable, keywordLibrariesRepository);
        if (actualIterator instanceof StafList) {
            int iteration = 0;
            for (AbstractStafObject item : ((StafList) actualIterator).getList()) {
                StatementReport iterationReport = createStatementReport((IStatement)item, TestResult.Pass);
                iterableReport.setErrorMessage("Iteration[" + (iteration++) + "] : " + item);
                iterationReport.setChildren(new ArrayList<>());
                for (IStatement statement : iterable.getStatements()) {
                    StatementReport statementReport = new StatementReport();
                    localSymTable.setSymbolValue(iterable.getVar().getValue().toString(), item);
                    try {
                        statement.execute(this, globalSymTable, localSymTable, keywordLibrariesRepository);
                        if (statement instanceof IStatementBlock) {
                            statementReport.setChildren(((IStatementBlock) statement).getStatementReports());
                        }
                        statementReport.setResult(TestResult.Pass);
                    } catch (Exception e) {
                        LOG.error("At " + statement);
                        statementReport.setErrorMessage("At " + statement);
                        statementReport.setResult(TestResult.Fail);
                        if (this.statementFailed != null) {
                            this.statementFailed.execute(statementReport);
                        }
                    } finally {
                        statementReport.setEnd(new Date());
                    }
                    iterationReport.getChildren().add(statementReport);
                }
                iterationReport.setResult(statementListTestResult(iterationReport.getChildren()));
                iterationReport.setEnd(new Date());
                iterableReport.getChildren().add(iterationReport);
            }

        }
        return iterableReport;
    }

    private StatementReport createStatementReport(IStatement statement, TestResult result) {
        StatementReport statementReport = new StatementReport();
        statementReport.setStatement(statement);
        statementReport.setStart(new Date());
        statementReport.setResult(result);
        return statementReport;
    }

    public void setStatementFailed(OnStatementFailed statementFailed) {
        this.statementFailed = statementFailed;
    }

    private TestResult statementListTestResult(List<StatementReport> statementReports) {
        for (StatementReport statementReport: statementReports) {
            if (statementReport.getResult() == TestResult.Fail) {
                return TestResult.Fail;
            }
        }
        return TestResult.Pass;
    }

    public Stack<KeywordCall> getCallStack() {
        return callStack;
    }
}
