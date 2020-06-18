package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.Main;
import com.sparkit.staf.core.ast.Assignment;
import com.sparkit.staf.core.ast.KeywordDeclaration;
import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.ast.TestCaseDeclaration;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.reports.TestSuiteReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
public class StafScriptInterpreter { // refactor
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    @Autowired
    private IImportsInterpreter importsInterpreter;
    @Autowired
    private KeywordLibrariesRepository keywordLibrariesRepository;
    @Autowired
    private SymbolsTable sharedGlobalSymbolsTable;

    @Value("#{systemProperties['testDirectory']}")
    private String testDirectory;

    @Autowired
    private TestcaseExecutor testCaseRunner;

    private List<TestSession> testSessionList;

    public StafScriptInterpreter() {
    }

    public List<TestSuiteReport> run(String currentDirectory, String testSuite, StafFile mainStafFile, int sessionCount) {
        testSessionList = new ArrayList<>();
        testDirectory = System.getProperty("testDirectory");
        logger.info("Started executing test suite : [" + testSuite + "] "
                + mainStafFile.getTestCaseDeclarationMap().size() + " Test cases found");
        try {
            Map<String, Assignment> varsAssignments = mainStafFile.getVariableDeclarationMap();
            Map<String, KeywordDeclaration> keywordsMap = mainStafFile.getKeywordDeclarationMap();
            String importRelativePath = mainStafFile.getFilePath().substring(0, mainStafFile.getFilePath().lastIndexOf("/"));
            this.importsInterpreter.loadImports(mainStafFile.getImports(), importRelativePath, testDirectory);
            if (varsAssignments != null) {
                this.sharedGlobalSymbolsTable.addVariablesMap(varsAssignments);
            }
            if (keywordsMap != null) {
                keywordLibrariesRepository.addUserDefinedKeywords(keywordsMap);
            }
            List<Map.Entry<String, TestCaseDeclaration>> entryList = new ArrayList<Map.Entry<String, TestCaseDeclaration>>(mainStafFile.getTestCaseDeclarationMap().entrySet());

            entryList.sort(Comparator.comparingInt(t -> t.getValue().getOrder()));

            ExecutorService es = Executors.newCachedThreadPool();
            for (int i = 0; i < sessionCount; i++) {
                TestSession testSession = testSession(mainStafFile, entryList);
                testSessionList.add(testSession);
                es.execute(testSession);
            }
            es.shutdown();
            boolean finished = es.awaitTermination(5, TimeUnit.MINUTES);
        } catch (Throwable e) {
            logger.error("Script execution stopped");
            logger.error(e.getClass().getName());
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return testSessionList.stream().map(TestSession::getTestSuiteReport).collect(Collectors.toList());
    }

    public void terminateTestExecution() {
        testSessionList.forEach(TestSession::stopTestExecution);
        logger.warn("Received test termination signal : stopping tests ...");
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    private TestSession testSession(StafFile mainStafFile, List<Map.Entry<String, TestCaseDeclaration>> testCasesEntryList) {
        return new TestSession(sharedGlobalSymbolsTable, testCaseRunner, mainStafFile, testCasesEntryList);
    }

}
