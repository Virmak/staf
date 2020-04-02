package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.Main;
import com.sparkit.staf.core.ast.Assignment;
import com.sparkit.staf.core.ast.IStatement;
import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.ast.TestCaseDeclaration;
import com.sparkit.staf.core.runtime.interpreter.exceptions.StatementExecutionFailedException;
import com.sparkit.staf.core.runtime.reports.TestCaseReport;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.reports.TestCaseResult;
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
        TestCaseDeclaration setup = mainStafFile.getTestCaseDeclarationMap().get("SETUP");
        TestCaseDeclaration tearDown = mainStafFile.getTestCaseDeclarationMap().get("TEARDOWN");
        try {
            Map<String, Assignment> varsAssignments = mainStafFile.getVariableDeclarationMap();
            this.importsInterpreter.loadImports(mainStafFile.getImports(), currentDirectory);
            if (varsAssignments != null) {
                this.globalSymTable.addVariablesMap(varsAssignments, keywordLibrariesRepository);
            }
            testCaseResult(setup);

            for (Map.Entry<String, TestCaseDeclaration> testCase : this.mainStafFile.getTestCaseDeclarationMap().entrySet()) {
                if (testCase.getKey().toLowerCase().equals("setup") || testCase.getKey().toLowerCase().equals("teardown")) {
                    continue;
                }
                testCaseResult(testCase.getValue());
            }
        } catch (Throwable e) {
            LOG.error("Script execution stopped");
            LOG.error(e.getClass());
            LOG.error(e.getMessage());
            e.printStackTrace();
        } finally {
            if (tearDown != null) {
                testCaseResult(tearDown);
            }
        }
        return reports;
    }

    public void testCaseResult(TestCaseDeclaration testCase) {
        TestCaseReport testCaseReport = new TestCaseReport();
        testCaseReport.setTestSuite(testSuite);
        testCaseReport.setTestCase(testCase.getName());
        testCaseReport.setStartTime(new Date());
        try {
            executeTestCase(testCase);
            testCaseReport.setResult(TestCaseResult.Passed);
            testCaseReport.setEndTime(new Date());
        } catch (StatementExecutionFailedException e) {
            testCaseReport.setResult(TestCaseResult.Failed);
            testCaseReport.setEndTime(new Date());
            e.printStackTrace();
        } finally {
            reports.add(testCaseReport);
        }
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
