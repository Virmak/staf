package com.sparkit.staf.runtime.loader;

import com.sparkit.staf.runtime.interpreter.ImportsInterpreter;

/* Interface used to load file keywords / vars into the AST*/
public interface IStafScriptBuilder {
    void load(String filePath, ImportsInterpreter importsInterpreter) throws Throwable;
}
