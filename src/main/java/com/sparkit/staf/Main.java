package com.sparkit.staf;

import com.sparkit.staf.ast.StafFile;
import com.sparkit.staf.runtime.interpreter.*;
import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;

import com.sparkit.staf.runtime.libs.exceptions.KeywordAlreadyRegisteredException;
import com.sparkit.staf.runtime.loader.IStafFileReader;
import com.sparkit.staf.runtime.loader.IStafScriptBuilder;
import com.sparkit.staf.visitors.StafFileVisitor;
import com.sparkit.staf.parser.StafLexer;
import com.sparkit.staf.parser.StafParser;
import org.antlr.v4.runtime.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException, KeywordAlreadyRegisteredException,
            InstantiationException, IllegalAccessException, InvocationTargetException {
        String mainScriptFilePath = System.getProperty("user.dir") + "/script.staf";
        IStafFileReader stafFileReader = new StafFileReader();
        StafFile mainScriptAST = stafFileReader.compile(mainScriptFilePath);
        SymbolsTable globalSymTable = new SymbolsTable(mainScriptAST.getVariableDeclarationMap());
        KeywordLibrariesRepository keywordsRepository = new KeywordLibrariesRepository(mainScriptAST.getKeywordDeclarationMap(),
                globalSymTable);
        IStafScriptBuilder scriptBuilder = new StafScriptBuilder(stafFileReader, globalSymTable, keywordsRepository);
        ImportsInterpreter importsInterpreter = new ImportsInterpreter(scriptBuilder, keywordsRepository);

        ASTInterpreter interpreter = new ASTInterpreter(importsInterpreter, mainScriptAST, globalSymTable, keywordsRepository,
                System.getProperty("user.dir"));
        interpreter.run();
        System.out.println("finished");
    }

    public static StafFile compileAST() throws IOException {
        String filePath = System.getProperty("user.dir") + "/script.staf";
        CharStream stafCharStream = CharStreams.fromFileName(filePath);
        StafLexer lexer = new StafLexer(stafCharStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        StafParser parser = new StafParser(tokens);
        StafParser.Staf_fileContext parseTree = parser.staf_file();
        return (StafFile) new StafFileVisitor().visitStaf_file(parseTree);
    }
}
