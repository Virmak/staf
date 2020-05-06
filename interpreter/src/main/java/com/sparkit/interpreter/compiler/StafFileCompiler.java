package com.sparkit.interpreter.compiler;

import com.sparkit.interpreter.compiler.ast.StafFile;
import com.sparkit.interpreter.compiler.parser.*;
import com.sparkit.interpreter.compiler.visitors.StafFileVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StafFileCompiler implements IStafCompiler {
    @Autowired
    private StafFileVisitor stafFileVisitor;

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
        stafFileVisitor.setFilePath(filePath);
        StafFile stafFile = (StafFile) stafFileVisitor.visitStaf_file(parseTree);
        stafFile.setFilePath(filePath);
        return stafFile;
    }
}
