package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.Main;
import com.sparkit.staf.core.ast.IStatement;
import com.sparkit.staf.core.runtime.interpreter.exceptions.InvalidArgsNumberKeywordCallException;
import com.sparkit.staf.core.runtime.interpreter.exceptions.StafRuntimeException;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.reports.StatementReport;
import com.sparkit.staf.core.runtime.reports.TestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class StatementBlockExecutor {
    private static final Logger LOG = LogManager.getLogger(Main.class);
    private OnStatementFailed statementFailed;

    public List<StatementReport> execute(List<IStatement> statements,
                                         OnStatementFailed statementFailed,
                                         SymbolsTable globalSymTable,
                                         KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        this.statementFailed = statementFailed;
        List<StatementReport> reports = new ArrayList<>();
        for (IStatement statement : statements) {
            StatementReport statementReport = new StatementReport();
            statementReport.setStatement(statement);
            statementReport.setStart(new Date());
            try {
                Object children = statement.execute(globalSymTable, null, keywordLibrariesRepository);
                if (children instanceof List) {
                    statementReport.setChildren((List)children);
                }
                statementReport.setResult(TestResult.Pass);
            }
            catch (InvalidArgsNumberKeywordCallException e) {
                statementReport.setResult(TestResult.Fail);
                statementReport.setErrorMessage(e.getMessage());
            }
            catch (StafRuntimeException e) {
                statementReport.setResult(TestResult.Fail);
                statementReport.setErrorMessage(e.getStatement() + "\n" + e.getMessage());
                statementFailed.execute(statementReport);
            } finally {
                statementReport.setEnd(new Date());
            }
            reports.add(statementReport);
        }
        return reports;
    }

    public List<StatementReport> execute(List<IStatement> statements,
                                         OnStatementFailed statementFailed,
                                         SymbolsTable globalSymTable,
                                         SymbolsTable localSymTable,
                                         KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        List<StatementReport> reports = new ArrayList<>();
        for (IStatement statement : statements) {
            StatementReport statementReport = new StatementReport();
            statementReport.setStatement(statement);
            statementReport.setStart(new Date());
            statementReport.setResult(TestResult.Pass);
            try {
                Object children = statement.execute(globalSymTable, localSymTable, keywordLibrariesRepository);
                if (children instanceof List) {
                    statementReport.setChildren((List)children);
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
}
