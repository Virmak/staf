package com.sparkit.staf.core.runtime.loader;

/* Interface used to load file keywords / vars into the AST*/
public interface IStafScriptLoader {
    void load(String filePath) throws Throwable;
}
