package com.sparkit.staf.runtime.loader;

import com.sparkit.staf.Main;
import com.sparkit.staf.ast.StafFile;
import com.sparkit.staf.runtime.interpreter.ImportsInterpreter;
import com.sparkit.staf.runtime.interpreter.StafScriptBuilder;
import com.sparkit.staf.runtime.interpreter.StafScriptRunner;
import com.sparkit.staf.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.runtime.loader.exceptions.TestSuiteMainScriptNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class TestLoader {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private final IStafConfig config;
    private final IStafFileReader stafFileReader;

    public TestLoader(IStafConfig config, IStafFileReader stafFileReader) {
        this.config = config;
        this.stafFileReader = stafFileReader;
    }

    public void runTests() {
        String testDirectory = config.getTestDirectory();
        for (String testSuite : config.testSuites()) {
            try {
                runTestScript(testSuite + "/main.staf", testSuite, testDirectory);
            } catch (TestSuiteMainScriptNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void runTestScript(String mainFilePath, String testSuitePath, String testDirectory) throws TestSuiteMainScriptNotFoundException {
        logger.info("Running test suite : " + testSuitePath);
        String fullPath = testDirectory + "/" + mainFilePath;
        StafFile scriptAST;
        try {
            scriptAST = stafFileReader.compile(fullPath);
        } catch (IOException e) {
            throw new TestSuiteMainScriptNotFoundException(testSuitePath);
        }
        SymbolsTable globalSymTable = new SymbolsTable();
        KeywordLibrariesRepository keywordsRepository = new KeywordLibrariesRepository(scriptAST.getKeywordDeclarationMap(),
                globalSymTable);
        IStafScriptBuilder scriptBuilder = new StafScriptBuilder(stafFileReader, globalSymTable, keywordsRepository);
        ImportsInterpreter importsInterpreter = new ImportsInterpreter(scriptBuilder, keywordsRepository, fullPath);

        StafScriptRunner interpreter = new StafScriptRunner(importsInterpreter, scriptAST, globalSymTable, keywordsRepository,
                testDirectory + "/" + testSuitePath);
        interpreter.run();
    }
}
