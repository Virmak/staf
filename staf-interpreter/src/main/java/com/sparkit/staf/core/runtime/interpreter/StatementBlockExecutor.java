package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.ExitLoopStatement;
import com.sparkit.staf.core.ast.IStatement;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.StafBoolean;
import com.sparkit.staf.core.ast.types.StafInteger;
import com.sparkit.staf.core.ast.types.StafList;
import com.sparkit.staf.core.runtime.interpreter.exceptions.FatalErrorException;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.reports.IReportableBlock;
import com.sparkit.staf.core.runtime.reports.StatementReport;
import com.sparkit.staf.core.utils.SharedConstants;
import com.sparkit.staf.domain.TestResult;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

@Component
public class StatementBlockExecutor {
    private static final Logger logger = LoggerFactory.getLogger(StatementBlockExecutor.class);
    private OnStatementFailed statementFailed;
    @Autowired
    @Getter
    private KeywordCallStack callStack;

    public static TestResult statementListTestResult(List<StatementReport> statementReports) {
        if (statementReports == null) {
            return TestResult.Pass;
        }
        for (StatementReport statementReport : statementReports) {
            if (statementReport.getResult() == TestResult.Fail) {
                return TestResult.Fail;
            }
        }
        return TestResult.Pass;
    }

    // Execute statement block like test case or user defined keyword
    public List<StatementReport> execute(IStatementBlock statementBlock,
                                         OnStatementFailed statementFailed,
                                         MemoryMap globalMemory,
                                         MemoryMap localMemory, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        List<StatementReport> reports = new ArrayList<>();
        for (IStatement statement : statementBlock.getStatements()) {
            StatementReport statementReport = createStatementReport(statement, TestResult.Pass);
            try {
                statement.execute(globalMemory, localMemory, keywordLibrariesRepository);
                if (statement instanceof IReportableBlock) {
                    statementReport.setChildren(((IReportableBlock) statement).getStatementReports());
                }
                statementReport.setResult(statementListTestResult(statementReport.getChildren()));
            } catch (EmptyStackException e) {
                logger.error("No browser open");
                statementReport.setErrorMessage(SharedConstants.NO_BROWSER_OPEN_ERROR + " At " + statement);
                statementReport.setResult(TestResult.Fail);
                throw new FatalErrorException(reports, e);
            } catch (Exception e) {
                logger.error("At {}", statement);
                statementReport.setErrorMessage("At " + statement);
                statementReport.setResult(TestResult.Fail);
                if (this.statementFailed != null) {
                    this.statementFailed.execute(statementReport);
                }
                reports.add(statementReport);
                e.printStackTrace();
                throw new FatalErrorException(reports, e);
            } finally {
                statementReport.setEnd(LocalDateTime.now());
                reports.add(statementReport);
            }
        }
        return reports;
    }

    // Execute loop statements
    public StatementReport executeIterable(IStafLoop stafLoop,
                                           MemoryMap globalSymbolsTable,
                                           MemoryMap localSymbolsTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        StatementReport loopReport = createStatementReport((IStatement) stafLoop, null);
        loopReport.setChildren(new ArrayList<>());
        AbstractStafObject tmp = null;  // used to save variable with the same name as the loop variable if it currently
        // exist in localSymTable so we can retrieve it later after for statement execution
        if (localSymbolsTable == null) {
            localSymbolsTable = new MemoryMap();
        } else {
            tmp = (AbstractStafObject) localSymbolsTable.getVariableValue(stafLoop.getLoopVariable().getValue().toString());
        }
        AbstractStafObject actualIterator = (AbstractStafObject) stafLoop.getIterator().evaluate(globalSymbolsTable, localSymbolsTable, keywordLibrariesRepository);
        if (actualIterator instanceof StafList) {
            int iteration = 0;
            for (AbstractStafObject item : ((StafList) actualIterator).getStafList()) {
                boolean loopExited = false;
                localSymbolsTable.setVariableValue(SharedConstants.LOOP_INDEX_VAR_MEMORY_KEY, new StafInteger(iteration));
                loopReport.setErrorMessage("Iteration[" + (iteration++) + "] : " + item);
                for (IStatement statement : stafLoop.getStatements()) {
                    StatementReport statementReport = new StatementReport();
                    localSymbolsTable.setVariableValue(stafLoop.getLoopVariable().getValue().toString(), item);
                    try {
                        statement.execute(globalSymbolsTable, localSymbolsTable, keywordLibrariesRepository);
                        if (statement instanceof ExitLoopStatement) {
                            ExitLoopStatement exitLoopStatement = (ExitLoopStatement) statement;
                            if (exitLoopStatement.getCondition() != null) {
                                StafBoolean conditionVal = (StafBoolean) (exitLoopStatement.getCondition()
                                        .evaluate(globalSymbolsTable, localSymbolsTable, keywordLibrariesRepository));
                                if ((boolean) conditionVal.getValue()) {
                                    loopExited = true;
                                    break;
                                }
                            } else {
                                loopExited = true;
                                break;
                            }
                        }
                        if (statement instanceof IStatementBlock) {
                            statementReport.setChildren(((IStatementBlock) statement).getStatementReports());
                        }
                        statementReport.setResult(statementListTestResult(statementReport.getChildren()));
                    } catch (Exception e) {
                        logger.error("At {}", statement);
                        statementReport.setErrorMessage("At " + statement);
                        statementReport.setResult(TestResult.Fail);
                        if (this.statementFailed != null) {
                            this.statementFailed.execute(statementReport);
                        }
                        e.printStackTrace();
                    } finally {
                        statementReport.setEnd(LocalDateTime.now());
                    }
                    loopReport.getChildren().add(statementReport);
                }
                if (loopExited) {
                    break;
                }
            }

        }
        return loopReport;
    }

    private StatementReport createStatementReport(IStatement statement, TestResult result) {
        StatementReport statementReport = new StatementReport();
        statementReport.setStatement(statement);
        statementReport.setStart(LocalDateTime.now());
        statementReport.setResult(result);
        return statementReport;
    }

    public void setStatementFailed(OnStatementFailed statementFailed) {
        this.statementFailed = statementFailed;
    }
}
