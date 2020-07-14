package com.sparkit.staf.core.compiler;

import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.parser.StafLexer;
import com.sparkit.staf.core.parser.StafParser;
import com.sparkit.staf.core.parser.SyntaxErrorException;
import com.sparkit.staf.core.parser.SyntaxErrorListener;
import com.sparkit.staf.core.visitors.StafFileVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

public class StafFileCompiler implements IStafCompiler {
    @Value("${testDirectory}")
    String testDirectory;
    @Autowired
    private StafFileVisitor stafFileVisitor;

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
            parseTree = parser.staf_file();
            stafFileVisitor.setFilePath(filePath);
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
