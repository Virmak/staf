package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.Assignment;
import com.sparkit.staf.core.ast.KeywordDeclaration;
import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.runtime.reports.TestSuiteReport;
import com.sparkit.staf.domain.ProjectConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
public class StafScriptInterpreter {
    private static final Logger logger = LoggerFactory.getLogger(StafScriptInterpreter.class);
    private static final int MAX_TEST_AWAIT_MINUTES = 5;
    private final Map<Integer, TestSession> allTestSessions = new HashMap<>();
    @Autowired
    private IImportsInterpreter importsInterpreter;
    @Autowired
    private TestCaseExecutor testCaseRunner;
    @Value("#{systemProperties['testDirectory']}")
    private String testDirectory;

    public List<TestSuiteReport> run(ProjectConfig projectConfig, TestSuite testSuite, StafFile mainStafFile, int sessionCount) {
        List<TestSession> testSuiteSessions = new ArrayList<>();
        testDirectory = System.getProperty("testDirectory");
        logger.info("Started executing test suite : [{}] {} Test cases found", testSuite.getTestSuiteName(), mainStafFile.getTestCaseDeclarationMap().size());
        try {
            Map<String, Assignment> varsAssignments = mainStafFile.getVariableDeclarationMap();
            Map<String, KeywordDeclaration> keywordsMap = mainStafFile.getKeywordDeclarationMap();
            String importRelativePath = mainStafFile.getFilePath().substring(0, mainStafFile.getFilePath().lastIndexOf('/'));
            importsInterpreter.loadImports(mainStafFile.getImports(), testSuite, importRelativePath, testDirectory);
            if (varsAssignments != null) {
                testSuite.getGlobalSharedSymbolsTable().addVariablesMap(varsAssignments, testSuite.getKeywordLibrariesRepository());
            }
            if (keywordsMap != null) {
                testSuite.getKeywordLibrariesRepository().addUserDefinedKeywords(keywordsMap);
            }
            testSuite.getTestCaseDeclarationMap().putAll(mainStafFile.getTestCaseDeclarationMap());
            TestSession.initSessionCount();
            ExecutorService executorService = Executors.newCachedThreadPool();
            for (int i = 0; i < sessionCount; i++) {
                TestSession testSession = testSession(projectConfig, testSuite, mainStafFile);
                testSuiteSessions.add(testSession);
                executorService.execute(testSession);
                allTestSessions.put(testSession.getSessionId(), testSession);
            }
            executorService.shutdown();
            executorService.awaitTermination(MAX_TEST_AWAIT_MINUTES, TimeUnit.MINUTES);
        } catch (Throwable e) {
            logger.error("Script execution stopped");
            logger.error(e.getClass().getName());
            logger.error(e.getMessage());
            logger.error("At {}", mainStafFile.getFilePath());
            e.printStackTrace();
        } finally {
            testSuiteSessions.forEach(testSession -> allTestSessions.remove(testSession.getSessionId()));
        }
        return testSuiteSessions.stream().map(TestSession::getTestSuiteReport).collect(Collectors.toList());
    }

    public void terminateTestExecution() {
        allTestSessions.forEach((key, value) -> {
            value.stopTestExecution();
            allTestSessions.remove(key);
        });
        logger.warn("Received test termination signal : stopping tests ...");
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    private TestSession testSession(ProjectConfig projectConfig, TestSuite testSuite, StafFile mainStafFile) {
        return new TestSession(testSuite.getGlobalSharedSymbolsTable(), testCaseRunner, mainStafFile, testSuite, projectConfig);
    }

}
