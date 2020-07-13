package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.parser.*;
import com.sparkit.staf.core.runtime.loader.IStafCompiler;
import com.sparkit.staf.core.visitors.StafFileVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

public class StafFileCompiler implements IStafCompiler {
    @Autowired
    private StafFileVisitor stafFileVisitor;
    @Value("${testDirectory}")
    String testDirectory;

    @Override
    public StafFile compile(String filePath) throws IOException, SyntaxErrorException {
        CharStream stafCharStream = CharStreams.fromFileName(filePath);
        StafLexer lexer = new StafLexer(stafCharStream);
        SyntaxErrorListener listener = new SyntaxErrorListener(getRelativeFilePath(filePath));
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


        stafFileVisitor.setFilePath(filePath);
        StafFile stafFile = (StafFile) stafFileVisitor.visitStaf_file(parseTree);
        stafFile.setFilePath(filePath);
        stafFile.setSyntaxErrors(listener.getSyntaxErrors());
        return stafFile;
    }

    @Override
    public StafFile compileWithErrors(String filePath) throws IOException {
        CharStream stafCharStream = CharStreams.fromFileName(filePath);
        StafLexer lexer = new StafLexer(stafCharStream);
        SyntaxErrorListener listener = new SyntaxErrorListener(getRelativeFilePath(filePath));
        lexer.addErrorListener(listener);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        StafParser parser = new StafParser(tokens);
        parser.addErrorListener(listener);
        StafParser.Staf_fileContext parseTree;
        try {
            parseTree = parser.staf_file(); stafFileVisitor.setFilePath(filePath);
            StafFile stafFile = (StafFile) stafFileVisitor.visitStaf_file(parseTree);
            stafFile.setFilePath(filePath);
            return stafFile;
        } catch (ParseCancellationException ignored) {
            stafFileVisitor.setFilePath(filePath);
            StafFile stafFile = new StafFile();
            stafFile.setFilePath(filePath);
            stafFile.setSyntaxErrors(listener.getSyntaxErrors());
            return stafFile;
        }
    }

    private String getRelativeFilePath(String filePath) {
        return filePath.substring(filePath.indexOf(testDirectory) + testDirectory.length() + 1);
    }
}
