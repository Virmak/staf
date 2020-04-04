package com.sparkit.staf.core.runtime.loader;

import com.sparkit.staf.core.runtime.interpreter.ImportsInterpreter;

/* Interface used to load file keywords / vars into the AST*/
public interface IStafScriptLoader {
    void load(String filePath, ImportsInterpreter importsInterpreter) throws Throwable;
}
