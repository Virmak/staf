package com.sparkit.staf;


import com.sparkit.staf.types.StafFile;
import com.sparkit.staf.visitors.StafFileVisitor;
import com.sparkit.staf.parser.StafLexer;
import com.sparkit.staf.parser.StafParser;
import org.antlr.v4.runtime.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.dir") + "/script.staf";
        CharStream stafCharStream = CharStreams.fromFileName(filePath);
        StafLexer lexer = new StafLexer(stafCharStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        StafParser parser = new StafParser(tokens);
        lexer.removeErrorListener(ConsoleErrorListener.INSTANCE);
        parser.removeErrorListener(ConsoleErrorListener.INSTANCE);
        StafParser.Staf_fileContext parseTree = parser.staf_file();
        StafParser.Imports_sectionContext imports = parser.imports_section();

        StafFile v = (StafFile) new StafFileVisitor().visitStaf_file(parseTree);
        System.out.println("finished");
    }
}
