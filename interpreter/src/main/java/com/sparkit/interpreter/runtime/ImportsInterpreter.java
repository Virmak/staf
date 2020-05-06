package com.sparkit.interpreter.runtime;

import com.sparkit.interpreter.compiler.ast.statement.ImportStatement;
import com.sparkit.interpreter.runtime.evaluator.statement.ImportExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImportsInterpreter {
    @Autowired
    private ImportExecutor importExecutor;


    /* Load imports */
    public void loadImports(List<ImportStatement> importStatements, String currentDirectory) throws Throwable {
        for (ImportStatement statement : importStatements) {
            importExecutor.execute(statement, currentDirectory);
        }
    }
}
