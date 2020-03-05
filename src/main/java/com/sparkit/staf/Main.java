package com.sparkit.staf;

import com.sparkit.staf.ast.StafFile;
import com.sparkit.staf.runtime.interpreter.*;
import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;

import com.sparkit.staf.runtime.loader.IStafFileReader;
import com.sparkit.staf.runtime.loader.IStafScriptBuilder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String mainScriptFilePath = System.getProperty("user.dir") + "/script.staf";
        System.out.println("Current directory " + System.getProperty("user.dir"));
        IStafFileReader stafFileReader = new StafFileReader();
        StafFile mainScriptAST = stafFileReader.compile(mainScriptFilePath);
        SymbolsTable globalSymTable = new SymbolsTable();
        KeywordLibrariesRepository keywordsRepository = new KeywordLibrariesRepository(mainScriptAST.getKeywordDeclarationMap(),
                globalSymTable);
        IStafScriptBuilder scriptBuilder = new StafScriptBuilder(stafFileReader, globalSymTable, keywordsRepository);
        ImportsInterpreter importsInterpreter = new ImportsInterpreter(scriptBuilder, keywordsRepository);

        StafScriptRunner interpreter = new StafScriptRunner(importsInterpreter, mainScriptAST, globalSymTable, keywordsRepository,
                System.getProperty("user.dir"));
        interpreter.run();
        System.out.println("finished");
    }
}
