package com.sparkit.staf.runtime.interpreter;

import com.sparkit.staf.Main;
import com.sparkit.staf.ast.Assignment;
import com.sparkit.staf.ast.IStatement;
import com.sparkit.staf.ast.StafFile;
import com.sparkit.staf.ast.TestCaseDeclaration;
import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Map;

public class StafScriptRunner {
    private static final Logger LOG = LogManager.getLogger(Main.class);
    private final ImportsInterpreter importsInterpreter;
    private final StafFile mainStafFile;
    private final KeywordLibrariesRepository keywordLibrariesRepository;
    private String currentDirectory;
    private SymbolsTable globalSymTable;


    public StafScriptRunner(ImportsInterpreter importsInterpreter, StafFile mainStafFile, SymbolsTable globalSymTable,
                            KeywordLibrariesRepository keywordLibrariesRepository, String currentDirectory) {
        this.importsInterpreter = importsInterpreter;
        this.mainStafFile = mainStafFile;
        this.globalSymTable = globalSymTable;
        this.keywordLibrariesRepository = keywordLibrariesRepository;
        this.currentDirectory = currentDirectory;
    }

    public void run() {
        try {

            Map<String, Assignment> varsAssignments = mainStafFile.getVariableDeclarationMap();
            this.importsInterpreter.loadImports(mainStafFile.getImports(), currentDirectory);
            if (varsAssignments != null) {
                this.globalSymTable.addVariablesMap(varsAssignments, keywordLibrariesRepository);
            }
            TestCaseDeclaration setup = this.mainStafFile.getTestCaseDeclarationMap().get("SETUP");
            if (setup != null) {
                executeTestCase(setup);
            }
            for (Map.Entry<String, TestCaseDeclaration> testCase : this.mainStafFile.getTestCaseDeclarationMap().entrySet()) {
                if (!testCase.getKey().equals("SETUP")) {
                    executeTestCase(testCase.getValue());
                }
            }

        } catch (Throwable e) {
            LOG.error(e.getClass());
            LOG.error(e.getMessage());
            e.printStackTrace();
            System.out.println("Fatal error script execution stopped");
            System.exit(1);
        }
    }

    public void executeTestCase(TestCaseDeclaration testCaseDeclaration) {
        LOG.info("Executing test case : " + testCaseDeclaration.getName());
        for (IStatement statement : testCaseDeclaration.getStatements()) {
            try {
                statement.execute(globalSymTable, null, keywordLibrariesRepository);
            } catch (Throwable e) {
                LOG.error("IN TEST CASE : " + testCaseDeclaration.getName() + " | " + e.getMessage());
                System.out.println("Fatal error script execution stopped");
                e.printStackTrace();
                System.exit(1);
            }
        }
        LOG.info("Finished executing test case : " + testCaseDeclaration.getName());
    }

}
