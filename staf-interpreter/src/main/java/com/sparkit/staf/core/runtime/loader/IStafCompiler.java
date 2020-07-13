package com.sparkit.staf.core.runtime.loader;

import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.parser.SyntaxErrorException;

import java.io.IOException;

public interface IStafCompiler {
    StafFile compile(String filePath) throws IOException, SyntaxErrorException;
    StafFile compileWithErrors(String filePath) throws IOException;
}
