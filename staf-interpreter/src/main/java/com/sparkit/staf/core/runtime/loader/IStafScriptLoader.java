package com.sparkit.staf.core.runtime.loader;

import com.sparkit.staf.core.runtime.interpreter.TestSuite;

/* Interface used to load file keywords / vars into the AST*/
public interface IStafScriptLoader {
    void load(TestSuite testSuite, String filePath) throws Throwable;
}
