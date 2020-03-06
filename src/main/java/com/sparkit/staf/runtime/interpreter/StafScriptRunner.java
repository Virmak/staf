package com.sparkit.staf.runtime.interpreter;

import com.sparkit.staf.ast.Assignment;
import com.sparkit.staf.ast.IStatement;
import com.sparkit.staf.ast.StafFile;
import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;

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
            this.importsInterpreter.loadImports(mainStafFile.getImports());
            if (varsAssignments != null) {
                this.globalSymTable.addVariablesMap(varsAssignments, keywordLibrariesRepository);
            }
            this.mainStafFile.getTestCaseDeclarationMap().forEach((k, v) -> {
                for (IStatement statement : v.getStatements()) {
                    try {
                        statement.execute(globalSymTable, null, keywordLibrariesRepository);
                    }
                    catch (Exception e) {
                        System.out.println("Exception raised while running test cases :");
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
