package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.ImportStatement;

import java.util.List;

public interface IImportsInterpreter {
    void loadImports(List<ImportStatement> importStatements, String currentDirectory) throws Throwable;
}
