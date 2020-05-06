package com.sparkit.interpreter.compiler;

import com.sparkit.interpreter.compiler.ast.StafFile;
import com.sparkit.interpreter.compiler.parser.SyntaxErrorException;

import java.io.IOException;

public interface IStafCompiler {
    public StafFile compile(String filePath) throws IOException, SyntaxErrorException;
}
