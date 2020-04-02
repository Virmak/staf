package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.parser.*;
import com.sparkit.staf.core.runtime.loader.IStafFileReader;
import com.sparkit.staf.core.visitors.StafFileVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.io.IOException;

public class StafFileReader implements IStafFileReader {
    @Override
    public StafFile compile(String filePath) throws IOException, SyntaxErrorException {
        CharStream stafCharStream = CharStreams.fromFileName(filePath);
        StafLexer lexer = new StafLexer(stafCharStream);
        SyntaxErrorListener listener = new SyntaxErrorListener();
        lexer.addErrorListener(listener);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        StafParser parser = new StafParser(tokens);
        parser.addErrorListener(listener);
        StafParser.Staf_fileContext parseTree;
        try {
            parseTree = parser.staf_file();
        } catch (ParseCancellationException e) {
            throw new SyntaxErrorException(filePath, e.getMessage());
        }

        for (SyntaxError syntaxError : listener.getSyntaxErrors()) {
            System.out.println(syntaxError.getMessage());
        }
        if (listener.getSyntaxErrors().size() > 0) {
            System.exit(0);
        }
        return (StafFile) new StafFileVisitor().visitStaf_file(parseTree);
    }
}
