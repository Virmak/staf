package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.Assignment;
import com.sparkit.staf.core.ast.KeywordDeclaration;
import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.runtime.reports.TestSuiteReport;
import com.sparkit.staf.core.utils.SharedConstants;
import com.sparkit.staf.domain.ProjectConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
public class StafScriptInterpreter {
    private static final Logger logger = LoggerFactory.getLogger(StafScriptInterpreter.class);
    private static final int MAX_TEST_AWAIT_MINUTES = 5;
    private final Map<Integer, TestSession> allTestSessions = new HashMap<>();
    private final IImportsInterpreter importsInterpreter;
    private final TestCaseExecutor testCaseRunner;
    @Value(SharedConstants.TEST_DIRECTORY_PROPERTY_VALUE)
    private String testDirectory;

    @Autowired
    public StafScriptInterpreter(IImportsInterpreter importsInterpreter, TestCaseExecutor testCaseRunner) {
        this.importsInterpreter = importsInterpreter;
        this.testCaseRunner = testCaseRunner;
    }

    public List<TestSuiteReport> run(ProjectConfig projectConfig, TestSuite testSuite, StafFile mainStafFile, int sessionCount) {
        List<TestSession> testSuiteSessions = new ArrayList<>();
        testDirectory = System.getProperty(SharedConstants.TEST_DIRECTORY_PROPERTY);
        try {
            Map<String, Assignment> varsAssignments = mainStafFile.getVariableDeclarationMap();
            List<KeywordDeclaration> keywordDeclarations = mainStafFile.getKeywordDeclarations();
            if (mainStafFile.getImports() != null) {
                String importRelativePath = mainStafFile.getFilePath().substring(0, mainStafFile.getFilePath().lastIndexOf('/'));
                importsInterpreter.loadImports(mainStafFile.getImports(), testSuite, importRelativePath, testDirectory);
            }
            if (varsAssignments != null) {
                testSuite.getGlobalSharedMemory().addVariablesMap(varsAssignments, testSuite.getKeywordLibrariesRepository());
            }
            if (keywordDeclarations != null) {
                testSuite.getKeywordLibrariesRepository().addUserDefinedKeywords(keywordDeclarations);
            }
            if (mainStafFile.getTestCaseDeclarationMap() != null) {
                testSuite.getTestCaseDeclarationMap().putAll(mainStafFile.getTestCaseDeclarationMap());
            }
            if (testSuite.getTestCaseDeclarationMap().isEmpty()) {
                logger.warn(SharedConstants.NO_TEST_CASE_FOUND);
                return new ArrayList<>();
            }

            logger.info(SharedConstants.STARTED_TEST_SUITE_EXECUTION, testSuite.getTestSuiteName(),
                    testSuite.getTestCaseDeclarationMap().size());

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
            logger.error(SharedConstants.SCRIPT_EXECUTION_STOPPED);
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
        for (Iterator<Map.Entry<Integer, TestSession>> iterator = allTestSessions.entrySet().iterator();
             iterator.hasNext(); ) {
            iterator.next().getValue().stopTestExecution();
            iterator.remove();
        }
        logger.warn(SharedConstants.RECEIVED_TEST_TERMINATION_SIGNAL);
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    private TestSession testSession(ProjectConfig projectConfig, TestSuite testSuite, StafFile mainStafFile) {
        return new TestSession(testSuite.getGlobalSharedMemory(), testCaseRunner, mainStafFile, testSuite, projectConfig);
    }

}
