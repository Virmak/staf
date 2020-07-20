package com.sparkit.staf.core.runtime.loader;

import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.compiler.IStafCompiler;
import com.sparkit.staf.core.models.RunTestCase;
import com.sparkit.staf.core.models.RunTestSuite;
import com.sparkit.staf.core.parser.SyntaxErrorException;
import com.sparkit.staf.core.runtime.interpreter.MemoryMap;
import com.sparkit.staf.core.runtime.interpreter.StafScriptInterpreter;
import com.sparkit.staf.core.runtime.interpreter.StatementBlockExecutor;
import com.sparkit.staf.core.runtime.interpreter.TestSuite;
import com.sparkit.staf.core.runtime.libs.BuiltInLibraryFactory;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.loader.exceptions.TestSuiteMainScriptNotFoundException;
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

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TestSuiteRunner {
    private static final Logger logger = LoggerFactory.getLogger(TestSuiteRunner.class);
    private final IStafCompiler stafCompiler;
    private final BuiltInLibraryFactory libraryFactory;
    private final StatementBlockExecutor statementBlockExecutor;
    private final StafScriptInterpreter interpreter;
    @Value(SharedConstants.TEST_DIRECTORY_PROPERTY_VALUE)
    private String testDirectory;

    @Autowired
    public TestSuiteRunner(IStafCompiler stafCompiler, BuiltInLibraryFactory libraryFactory, StatementBlockExecutor statementBlockExecutor, StafScriptInterpreter interpreter) {
        this.stafCompiler = stafCompiler;
        this.libraryFactory = libraryFactory;
        this.statementBlockExecutor = statementBlockExecutor;
        this.interpreter = interpreter;
    }

    public List<TestSuiteReport> runTests(RunTestSuite runTestSuiteRequest, int sessionCount, ProjectConfig projectConfig)
            throws SyntaxErrorException, TestSuiteMainScriptNotFoundException {
        logger.info(SharedConstants.STARTED_RUNNING_TESTS, LocalDateTime.now());
        List<TestSuiteReport> testSuiteReport = runTestScript(runTestSuiteRequest.getName() + "/" + SharedConstants.TEST_SUITE_MAIN_FILE,
                runTestSuiteRequest, testDirectory, sessionCount, projectConfig);
        logger.info(SharedConstants.FINISHED_RUNNING_TESTS, LocalDateTime.now());
        return testSuiteReport;
    }

    public List<TestSuiteReport> runTestScript(String mainFilePath, RunTestSuite runTestSuiteRequest, String testDirectory,
                                               int sessionCount, ProjectConfig projectConfig)
            throws TestSuiteMainScriptNotFoundException, SyntaxErrorException {
        Map<String, RunTestCase> selectedTestCaseMap = new HashMap<>();
        runTestSuiteRequest.getTestCases().forEach(testCase -> selectedTestCaseMap.put(testCase.getName().toLowerCase(), testCase));
        TestSuite testSuite = new TestSuite(runTestSuiteRequest.getName(), testDirectory, symbolsTable(), keywordLibrariesRepository(), selectedTestCaseMap);

        String fullPath = getFilePath(testDirectory, projectConfig.getLocation(), mainFilePath);
        StafFile scriptAST;
        try {
            scriptAST = stafCompiler.compile(fullPath);
        } catch (IOException e) {
            throw new TestSuiteMainScriptNotFoundException(runTestSuiteRequest.getName(), fullPath);
        }
        return interpreter.run(projectConfig, testSuite, scriptAST, sessionCount);
    }

    private String getFilePath(String testDirectory, String projectDirectory, String mainScriptFilePath) {
        File project = new File(testDirectory, projectDirectory);
        File scriptFile = new File(project, mainScriptFilePath);
        return scriptFile.getPath();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public KeywordLibrariesRepository keywordLibrariesRepository() {
        return new KeywordLibrariesRepository(libraryFactory, statementBlockExecutor);
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public MemoryMap symbolsTable() {
        return new MemoryMap();
    }
}
