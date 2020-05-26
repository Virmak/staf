package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.Main;
import com.sparkit.staf.core.ast.Assignment;
import com.sparkit.staf.core.ast.KeywordDeclaration;
import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.ast.TestCaseDeclaration;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.KeywordCall;
import com.sparkit.staf.core.ast.types.StafString;
import com.sparkit.staf.core.runtime.interpreter.exceptions.FatalErrorException;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.loader.IStafConfig;
import com.sparkit.staf.core.runtime.reports.StatementReport;
import com.sparkit.staf.core.runtime.reports.TestCaseReport;
import com.sparkit.staf.domain.TestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StafScriptInterpreter implements IStafScriptInterpreter {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    @Autowired
    private IImportsInterpreter importsInterpreter;
    @Autowired
    private KeywordLibrariesRepository keywordLibrariesRepository;
    @Autowired
    private SymbolsTable globalSymTable;
    @Autowired
    private IStafConfig config;
    @Autowired
    private StatementBlockExecutor statementBlockExecutor;

    @Value("#{systemProperties['testDirectory']}")
    private String testDirectory;

    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    public StafScriptInterpreter() {
    }

    public List<TestCaseReport> run(String currentDirectory, String testSuite, StafFile mainStafFile) {
        List<TestCaseReport> reports = new ArrayList<>();
        TestCaseDeclaration setup = mainStafFile.getTestCaseDeclarationMap().get("setup");
        TestCaseDeclaration tearDown = mainStafFile.getTestCaseDeclarationMap().get("teardown");
        testDirectory = System.getProperty("testDirectory");
        logger.info("Started executing test suite : [" + testSuite + "] "
                + mainStafFile.getTestCaseDeclarationMap().size() + " Test cases found");
        try {
            Map<String, Assignment> varsAssignments = mainStafFile.getVariableDeclarationMap();
            Map<String, KeywordDeclaration> keywordsMap = mainStafFile.getKeywordDeclarationMap();
            String importRelativePath = mainStafFile.getFilePath().substring(0, mainStafFile.getFilePath().lastIndexOf("/"));
            this.importsInterpreter.loadImports(mainStafFile.getImports(), importRelativePath, testDirectory);
            if (varsAssignments != null) {
                this.globalSymTable.addVariablesMap(varsAssignments, keywordLibrariesRepository);
            }
            if (keywordsMap != null) {
                keywordLibrariesRepository.addUserDefinedKeywords(keywordsMap);
            }
            if (setup != null) {
                reports.add(executeTestCase(testSuite, "SETUP", setup));
            }
            List<Map.Entry<String, TestCaseDeclaration>> entryList = new ArrayList<Map.Entry<String, TestCaseDeclaration>>(mainStafFile.getTestCaseDeclarationMap().entrySet());

            Collections.sort(
                    entryList, new Comparator<Map.Entry<String, TestCaseDeclaration>>() {
                        @Override
                        public int compare(Map.Entry<String, TestCaseDeclaration> t1,
                                           Map.Entry<String, TestCaseDeclaration> t2) {
                            return t1.getValue().getOrder() - t2.getValue().getOrder();
                        }
                    }
            );

            for (Map.Entry<String, TestCaseDeclaration> testCase : entryList) {
                if (testCase.getKey().toLowerCase().equals("setup") || testCase.getKey().toLowerCase().equals("teardown")
                        || testCase.getValue().isIgnored()) {
                    continue;
                }
                reports.add(executeTestCase(testSuite, testCase.getKey(), testCase.getValue()));
            }
        } catch (Throwable e) {
            logger.error("Script execution stopped");
            logger.error(e.getClass().getName());
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            if (tearDown != null) {
                reports.add(executeTestCase(testSuite, "TEARDOWN", tearDown));
            }
        }
        return reports;
    }

    public TestCaseReport executeTestCase(String testSuite, String testCaseName, TestCaseDeclaration testCaseDeclaration) {
        TestCaseReport testCaseReport = new TestCaseReport();
        testCaseReport.setTestSuite(testSuite);
        testCaseReport.setTestCase(testCaseName);
        testCaseReport.setStart(new Date());
        testCaseReport.setResult(TestResult.Pass);
        testCaseReport.setStatementReports(new ArrayList<>());
        String lastErrorMessage = null;
        logger.info("Started executing test case : [" + testCaseDeclaration.getName() + "]");
        OnStatementFailed statementFailed = (statementReport) -> {
            testCaseReport.setResult(TestResult.Fail);
            if (!keywordLibrariesRepository.isKeywordDeclared("capturescreenshot")) {
                return;
            }
            StafString screenShotPath = new StafString(
                    testDirectory + "/" + config.getProjectDir() + "/" + testSuite + "/" + config.getReportingDirectory() + "/screenshot-" + testSuite + "-" + testCaseName + "-" + new Date().getTime() + ".png");
            try {
                KeywordCall captureScreenshotKeyword = new KeywordCall("capturescreenshot",
                        Arrays.asList(new AbstractStafObject[]{screenShotPath}));
                captureScreenshotKeyword.execute(statementBlockExecutor, globalSymTable, null, keywordLibrariesRepository);
            } catch (EmptyStackException e) {
                logger.error("No browser open");
                statementReport.setErrorMessage("No browser open");
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            statementReport.setScreenShot(screenShotPath.getValue().toString());
        };
        statementBlockExecutor.setStatementFailed(statementFailed);
        try {
            SymbolsTable localSymTable = new SymbolsTable();
            autowireCapableBeanFactory.autowireBean(localSymTable);
            testCaseReport.setStatementReports(
                    statementBlockExecutor.execute(testCaseDeclaration, statementFailed, globalSymTable,
                            localSymTable, keywordLibrariesRepository));
            if (!testCasePass(testCaseReport)) {
                testCaseReport.setResult(TestResult.Fail);
            }
        } catch (Throwable e) {
            if (e instanceof FatalErrorException) {
                testCaseReport.setStatementReports(((FatalErrorException)e).getReports());
            }
            testCaseReport.setResult(TestResult.Fail);
            lastErrorMessage = e.getMessage();
            logger.error("Executing statement failed at [" + testSuite + "] : "
                    + testCaseDeclaration.getName()
                    + " | " + e.getMessage());
            e.printStackTrace();
        }
        testCaseReport.setEnd(new Date());
        testCaseReport.setErrorMessage(lastErrorMessage);

        logger.info("Finished executing test case : [" + testCaseDeclaration.getName() + "] " + testCaseReport.getResult());
        return testCaseReport;
    }

    private boolean testCasePass(TestCaseReport testCaseReport) {
        for (StatementReport statementReport : testCaseReport.getStatementReports()) {
            if (statementReport.getResult() == TestResult.Fail) {
                return false;
            }
        }
        return true;
    }

}
