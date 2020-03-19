package com.sparkit.staf.runtime.interpreter;

import com.sparkit.staf.Main;
import com.sparkit.staf.ast.Assignment;
import com.sparkit.staf.ast.IStatement;
import com.sparkit.staf.ast.StafFile;
import com.sparkit.staf.ast.TestCaseDeclaration;
import com.sparkit.staf.runtime.interpreter.exceptions.StatementExecutionFailedException;
import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.runtime.reports.TestCaseReport;
import com.sparkit.staf.runtime.reports.TestCaseResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class StafScriptInterpreter {
    private static final Logger LOG = LogManager.getLogger(Main.class);
    private final ImportsInterpreter importsInterpreter;
    private final StafFile mainStafFile;
    private final KeywordLibrariesRepository keywordLibrariesRepository;
    private final String testSuite;
    private String currentDirectory;
    private SymbolsTable globalSymTable;
    private List<TestCaseReport> reports = new ArrayList<>();

    public StafScriptInterpreter(ImportsInterpreter importsInterpreter, StafFile mainStafFile, SymbolsTable globalSymTable,
                                 KeywordLibrariesRepository keywordLibrariesRepository, String currentDirectory, String testSuite) {
        this.importsInterpreter = importsInterpreter;
        this.mainStafFile = mainStafFile;
        this.globalSymTable = globalSymTable;
        this.keywordLibrariesRepository = keywordLibrariesRepository;
        this.currentDirectory = currentDirectory;
        this.testSuite = testSuite;
    }

    public List<TestCaseReport> run() {
        try {

            Map<String, Assignment> varsAssignments = mainStafFile.getVariableDeclarationMap();
            this.importsInterpreter.loadImports(mainStafFile.getImports(), currentDirectory);
            if (varsAssignments != null) {
                this.globalSymTable.addVariablesMap(varsAssignments, keywordLibrariesRepository);
            }
            for (Map.Entry<String, TestCaseDeclaration> testCase : this.mainStafFile.getTestCaseDeclarationMap().entrySet()) {
                TestCaseReport testCaseReport = new TestCaseReport();
                testCaseReport.setTestSuite(testSuite);
                testCaseReport.setTestCase(testCase.getValue().getName());
                testCaseReport.setStartTime(new Date());
                try {
                    executeTestCase(testCase.getValue());
                    testCaseReport.setResult(TestCaseResult.Passed);
                } catch (StatementExecutionFailedException e) {
                    testCaseReport.setResult(TestCaseResult.Failed);
                    testCaseReport.setEndTime(new Date());
                    e.printStackTrace();
                } finally {
                    testCaseReport.setEndTime(new Date());
                    reports.add(testCaseReport);
                }
            }
        } catch (Throwable e) {
            LOG.error("Script execution stopped");
            LOG.error(e.getClass());
            LOG.error(e.getMessage());
            e.printStackTrace();
            //System.out.println("Fatal error script execution stopped");
            //System.exit(1);
        } finally {
        }

        return reports;
    }

    public void executeTestCase(TestCaseDeclaration testCaseDeclaration) throws StatementExecutionFailedException {
        LOG.info("Executing test case : " + testCaseDeclaration.getName());
        for (IStatement statement : testCaseDeclaration.getStatements()) {
            try {
                statement.execute(globalSymTable, null, keywordLibrariesRepository);
            } catch (Throwable e) {
                LOG.error("Executing statement failed at [" + testSuite + "] : "  + testCaseDeclaration.getName()
                        + " | " + e.getMessage());
                e.printStackTrace();
                throw new StatementExecutionFailedException();
            } finally {
            }
        }
        LOG.info("Finished executing test case : " + testCaseDeclaration.getName());
    }

}
