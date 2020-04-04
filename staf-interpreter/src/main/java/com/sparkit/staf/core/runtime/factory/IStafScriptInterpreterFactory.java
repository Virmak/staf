package com.sparkit.staf.core.runtime.factory;

import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.runtime.interpreter.IStafScriptInterpreter;

public interface IStafScriptInterpreterFactory {
    IStafScriptInterpreter getScriptInterpreter(StafFile scriptAST, String filePath, String currentDirectory,
                                                String testSuiteName, String testDirectory);
}
