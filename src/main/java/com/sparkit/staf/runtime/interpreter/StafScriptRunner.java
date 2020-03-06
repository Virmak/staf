package com.sparkit.staf.runtime.interpreter;

import com.sparkit.staf.ast.Assignment;
import com.sparkit.staf.ast.IStatement;
import com.sparkit.staf.ast.StafFile;
import com.sparkit.staf.ast.TestCaseDeclaration;
import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;
import junit.framework.TestCase;

import java.util.Map;

public class StafScriptRunner {
    private final ImportsInterpreter importsInterpreter;
    private final StafFile mainStafFile;
    private final KeywordLibrariesRepository keywordLibrariesRepository;
    private String currentDirectory;
    private SymbolsTable globalSymTable;

    public StafScriptRunner(ImportsInterpreter importsInterpreter, StafFile mainStafFile, SymbolsTable globalSymTable,
                            KeywordLibrariesRepository keywordLibrariesRepository, String currentDirectory) {
        this.importsInterpreter = importsInterpreter;
        this.mainStafFile = mainStafFile;
        this.keywordLibrariesRepository = keywordLibrariesRepository;
        this.currentDirectory = currentDirectory;
        this.globalSymTable = globalSymTable;
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
            e.printStackTrace();
        }
    }

    public void executeTestCase(TestCaseDeclaration testCaseDeclaration) {
        for (IStatement statement : testCaseDeclaration.getStatements()) {
            try {
                statement.execute(globalSymTable, null, keywordLibrariesRepository);
            }
            catch (Exception e) {
                System.out.println("Exception raised while running test cases :");
                e.printStackTrace();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

}
