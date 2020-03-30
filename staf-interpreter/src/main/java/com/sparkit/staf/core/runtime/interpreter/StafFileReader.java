package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.parser.StafLexer;
import com.sparkit.staf.core.parser.StafParser;
import com.sparkit.staf.core.parser.SyntaxError;
import com.sparkit.staf.core.parser.SyntaxErrorListener;
import com.sparkit.staf.core.runtime.loader.IStafFileReader;
import com.sparkit.staf.core.visitors.StafFileVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class StafFileReader implements IStafFileReader {
    @Override
    public StafFile compile(String filePath) throws IOException {
        CharStream stafCharStream = CharStreams.fromFileName(filePath);
        StafLexer lexer = new StafLexer(stafCharStream);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        StafParser parser = new StafParser(tokens);
        SyntaxErrorListener listener = new SyntaxErrorListener();
        parser.addErrorListener(listener);
        StafParser.Staf_fileContext parseTree = parser.staf_file();

        for (SyntaxError syntaxError : listener.getSyntaxErrors()) {
            System.out.println(syntaxError.getMessage());
        }
        if (listener.getSyntaxErrors().size() > 0) {
            System.exit(0);
        }
        return (StafFile) new StafFileVisitor().visitStaf_file(parseTree);
    }
}
