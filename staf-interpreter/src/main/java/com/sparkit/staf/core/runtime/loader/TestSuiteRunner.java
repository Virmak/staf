package com.sparkit.staf.core.runtime.loader;

import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.parser.SyntaxErrorException;
import com.sparkit.staf.core.runtime.interpreter.StafScriptInterpreter;
import com.sparkit.staf.core.runtime.interpreter.StatementBlockExecutor;
import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.interpreter.TestSuite;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.libs.LibraryFactory;
import com.sparkit.staf.core.runtime.loader.exceptions.TestSuiteMainScriptNotFoundException;
import com.sparkit.staf.core.runtime.reports.TestSuiteReport;
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
import java.util.List;

@Component
public class TestSuiteRunner {
    private static final Logger logger = LoggerFactory.getLogger(TestSuiteRunner.class);
    @Autowired
    private IStafConfig config;
    @Autowired
    private IStafCompiler stafCompiler;
    @Autowired
    private StafScriptInterpreter interpreter;

    @Value("${testDirectory}")
    private String testDirectory;
    @Autowired
    private LibraryFactory libraryFactory;
    @Autowired
    private StatementBlockExecutor statementBlockExecutor;

    public List<TestSuiteReport> runTests(String testSuite, int sessionCount) throws SyntaxErrorException, TestSuiteMainScriptNotFoundException {
        logger.info("Started running tests at {}", LocalDateTime.now());
        List<TestSuiteReport> testSuiteReport = runTestScript(testSuite + "/main.staf", testSuite, testDirectory, sessionCount);
        logger.info("Finished running tests at {}", LocalDateTime.now());
        return testSuiteReport;
    }

    public List<TestSuiteReport> runTestScript(String mainFilePath, String testSuiteName, String testDirectory, int sessionCount)
            throws TestSuiteMainScriptNotFoundException, SyntaxErrorException {
        logger.info("Running test suite : {}", testSuiteName);
        TestSuite testSuite = new TestSuite(testSuiteName, testDirectory, new SymbolsTable(), keywordLibrariesRepository());

        String fullPath = getFilePath(testDirectory, config.getProjectDir(), mainFilePath);
        StafFile scriptAST;
        try {
            scriptAST = stafCompiler.compile(fullPath);
        } catch (IOException e) {
            throw new TestSuiteMainScriptNotFoundException(testSuiteName);
        }
        return interpreter.run(testSuite, scriptAST, sessionCount);
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
}
