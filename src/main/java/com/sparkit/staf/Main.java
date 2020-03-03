package com.sparkit.staf;

import com.sparkit.staf.ast.StafFile;
import com.sparkit.staf.runtime.interpreter.ASTInterpreter;
import com.sparkit.staf.runtime.interpreter.ImportsInterpreter;
import com.sparkit.staf.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;

import com.sparkit.staf.runtime.libs.exceptions.KeywordAlreadyRegisteredException;
import com.sparkit.staf.visitors.StafFileVisitor;
import com.sparkit.staf.parser.StafLexer;
import com.sparkit.staf.parser.StafParser;
import org.antlr.v4.runtime.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException, KeywordAlreadyRegisteredException,
            InstantiationException, IllegalAccessException, InvocationTargetException {
        StafFile ast = compileAST();

        SymbolsTable globalSymTable = new SymbolsTable(ast.getVariableDeclarationMap());
        KeywordLibrariesRepository keywordsRepository = new KeywordLibrariesRepository(ast.getKeywordDeclarationMap(),
                globalSymTable);
        ImportsInterpreter importsInterpreter = new ImportsInterpreter(ast.getImports(), keywordsRepository);


        ASTInterpreter interpreter = new ASTInterpreter(importsInterpreter, ast, globalSymTable, keywordsRepository,
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
