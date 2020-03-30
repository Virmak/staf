package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.KeywordDeclaration;

public class KeywordInterpreter {
    private final KeywordDeclaration keywordDeclaration;
    private final SymbolsTable globalSymTable;
    private final SymbolsTable localSymTable;

    public KeywordInterpreter(KeywordDeclaration keywordDeclaration, SymbolsTable globalSymTable) {
        this.keywordDeclaration = keywordDeclaration;
        this.globalSymTable = globalSymTable;
        this.localSymTable = new SymbolsTable();
    }


}
