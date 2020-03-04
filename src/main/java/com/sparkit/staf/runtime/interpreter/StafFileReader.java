package com.sparkit.staf.runtime.interpreter;

import com.sparkit.staf.ast.StafFile;
import com.sparkit.staf.parser.StafLexer;
import com.sparkit.staf.parser.StafParser;
import com.sparkit.staf.runtime.loader.IStafFileReader;
import com.sparkit.staf.visitors.StafFileVisitor;
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
        StafParser.Staf_fileContext parseTree = parser.staf_file();
        return (StafFile) new StafFileVisitor().visitStaf_file(parseTree);
    }
}
