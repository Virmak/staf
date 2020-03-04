package com.sparkit.staf.runtime.interpreter;

import com.sparkit.staf.ast.IStatement;
import com.sparkit.staf.ast.StafFile;
import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;

public class ASTInterpreter {
    private final ImportsInterpreter importsInterpreter;
    private final StafFile mainStafFile;
    private final KeywordLibrariesRepository keywordLibrariesRepository;
    private String currentDirectory;
    private SymbolsTable symbolsTable;

    public ASTInterpreter(ImportsInterpreter importsInterpreter, StafFile mainStafFile, SymbolsTable symbolsTable, KeywordLibrariesRepository keywordLibrariesRepository, String currentDirectory) {
        this.importsInterpreter = importsInterpreter;
        this.mainStafFile = mainStafFile;
        this.keywordLibrariesRepository = keywordLibrariesRepository;
        this.currentDirectory = currentDirectory;
        this.symbolsTable = symbolsTable;
    }

    public void run() {
        try {
            this.importsInterpreter.loadImports(mainStafFile.getImports());
            this.mainStafFile.getTestCaseDeclarationMap().forEach((k, v) -> {
                for (IStatement statement : v.getStatements()) {
                    try {
                        statement.execute(symbolsTable, null, keywordLibrariesRepository);
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
