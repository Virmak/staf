package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.Main;
import com.sparkit.staf.core.ast.Assignment;
import com.sparkit.staf.core.ast.IStatement;
import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.ast.TestCaseDeclaration;
import com.sparkit.staf.core.ast.types.StafString;
import com.sparkit.staf.core.runtime.interpreter.exceptions.StafRuntimeException;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.loader.IStafConfig;
import com.sparkit.staf.core.runtime.reports.StatementReport;
import com.sparkit.staf.core.runtime.reports.TestCaseReport;
import com.sparkit.staf.core.runtime.reports.TestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class StafScriptInterpreter implements IStafScriptInterpreter {
    private static final Logger LOG = LogManager.getLogger(Main.class);
    private final IImportsInterpreter importsInterpreter;
    private final StafFile mainStafFile;
    private final KeywordLibrariesRepository keywordLibrariesRepository;
    private final String filePath;
    private final String testSuite;
    private String currentDirectory;
    private SymbolsTable globalSymTable;
    private IStafConfig config;
    private StatementBlockExecutor statementBlockExecutor;

    @Value("#{systemProperties['testDirectory']}")
    private String testDirectory;

    public StafScriptInterpreter(IImportsInterpreter importsInterpreter, IStafConfig config, StafFile mainStafFile,
                                 SymbolsTable globalSymTable, KeywordLibrariesRepository keywordLibrariesRepository,
                                 String currentDirectory, String filePath, String testSuite, StatementBlockExecutor statementBlockExecutor) {
        this.importsInterpreter = importsInterpreter;
        this.config = config;
        this.mainStafFile = mainStafFile;
        this.globalSymTable = globalSymTable;
        this.keywordLibrariesRepository = keywordLibrariesRepository;
        this.currentDirectory = currentDirectory;
        this.filePath = filePath;
        this.testSuite = testSuite;
        this.statementBlockExecutor = statementBlockExecutor;
        this.testDirectory = System.getProperty("testDirectory");
    }

    public List<TestCaseReport> run() {
        List<TestCaseReport> reports = new ArrayList<>();
        TestCaseDeclaration setup = mainStafFile.getTestCaseDeclarationMap().get("setup");
        TestCaseDeclaration tearDown = mainStafFile.getTestCaseDeclarationMap().get("teardown");
        try {
            Map<String, Assignment> varsAssignments = mainStafFile.getVariableDeclarationMap();
            this.importsInterpreter.loadImports(mainStafFile.getImports(), currentDirectory);
            if (varsAssignments != null) {
                this.globalSymTable.addVariablesMap(varsAssignments, keywordLibrariesRepository);
            }
            if (setup != null) {
                reports.add(executeTestCase("SETUP", setup));
            }

            for (Map.Entry<String, TestCaseDeclaration> testCase : this.mainStafFile.getTestCaseDeclarationMap().entrySet()) {
                if (testCase.getKey().toLowerCase().equals("setup") || testCase.getKey().toLowerCase().equals("teardown")) {
                    continue;
                }
                reports.add(executeTestCase(testCase.getKey(), testCase.getValue()));
            }
        } catch (Throwable e) {
            LOG.error("Script execution stopped");
            LOG.error(e.getClass());
            LOG.error(e.getMessage());
            e.printStackTrace();
        } finally {
            if (tearDown != null) {
                reports.add(executeTestCase("TEARDOWN", tearDown));
            }
        }
        return reports;
    }

    public TestCaseReport executeTestCase(String testCaseName, TestCaseDeclaration testCaseDeclaration) {
        TestCaseReport testCaseReport = new TestCaseReport();
        testCaseReport.setTestSuite(testSuite);
        testCaseReport.setTestCase(testCaseName);
        testCaseReport.setStart(new Date());
        testCaseReport.setResult(TestResult.Pass);
        testCaseReport.setStatementReports(new ArrayList<>());
        String lastErrorMessage = null;
        LOG.info("Executing test case : " + testCaseDeclaration.getName());
        OnStatementFailed statementFailed = (statementReport) -> {
            StafString screenShotPath = new StafString(
                    testDirectory + "/" + config.getProjectDir() + "/" + testSuite + "/" + config.getReportingDirectory() + "/screenshot-" + testSuite + "-" + testCaseName + "-" + new Date().getTime() + ".png");
            try {
                keywordLibrariesRepository.invokeKeyword("capture screenshot", new Object[]{screenShotPath});
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            statementReport.setScreenShot(screenShotPath.getValue().toString());
        };
        try {
            List<StatementReport> statementReports =
                    statementBlockExecutor.execute(testCaseDeclaration.getStatements(), statementFailed, globalSymTable, keywordLibrariesRepository);
            testCaseReport.setStatementReports(statementReports);
        } catch (Throwable e) {
            testCaseReport.setResult(TestResult.Fail);
            lastErrorMessage = e.getMessage();
            LOG.error("Executing statement failed at [" + testSuite + "] : "
                    + testCaseDeclaration.getName()
                    + " | " + e.getMessage());
            e.printStackTrace();
        }
        /*
        for (IStatement statement : testCaseDeclaration.getStatements()) {
            StatementReport statementReport = new StatementReport();
            statementReport.setStatement(statement);
            statementReport.setStart(new Date());
            try {
                statement.execute(globalSymTable, null, keywordLibrariesRepository);
                statementReport.setResult(TestResult.Pass);
            } catch (StafRuntimeException e) {
                testCaseReport.setResult(TestResult.Fail);
                statementReport.setResult(TestResult.Fail);
                statementReport.setErrorMessage(e.getStatement() + "\n" + e.getMessage());
                // Take screenshot
                StafString screenShotPath = new StafString(
                        testDirectory + "/" + config.getProjectDir() + "/" + testSuite + "/" + config.getReportingDirectory() + "/screenshot-" + testSuite + "-" + testCaseName + "-" + new Date().getTime() + ".png");

                try {
                    keywordLibrariesRepository.invokeKeyword("capture screenshot", new Object[]{screenShotPath});
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                lastErrorMessage = e.getStatement().toString();
            } catch (Throwable e) {
                statementReport.setResult(TestResult.Fail);
                statementReport.setErrorMessage(e.getMessage());
                LOG.error("Executing statement failed at [" + testSuite + "] : " + testCaseDeclaration.getName()
                        + " | " + e.getMessage());
                e.printStackTrace();
                lastErrorMessage = e.getMessage();
                testCaseReport.setResult(TestResult.Fail);
            } finally {
                statementReport.setEnd(new Date());
                testCaseReport.getStatementReports().add(statementReport);
            }
        }
*/
        testCaseReport.setEnd(new Date());
        testCaseReport.setErrorMessage(lastErrorMessage);

        LOG.info("Finished executing test case : " + testCaseDeclaration.getName());
        return testCaseReport;
    }

}
