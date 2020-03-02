package com.sparkit.staf.ast;

import com.sparkit.staf.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;

public class ImportStatement implements IStatement {
    private String path;
    private ImportTypes type;

    public ImportStatement(String path) {
        this.path = path;
        this.resolveType();
    }

    public ImportStatement() {
    }

    public ImportTypes getType() {
        return type;
    }

    public void setType(ImportTypes type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private void resolveType() {
        if (path.contains("\"")) { // Import user-defined library or file with a relative path
            path = path.replaceAll("\"", "");
            if (path.charAt(0) == '.') { // import file
                type = ImportTypes.FILE;
            } else { // user defined library
                type = ImportTypes.USER_DEFINED_LIBRARY;
            }
        } else { // builtin library
            type = ImportTypes.BUILT_IN_LIBRARY;
        }
    }

    @Override
    public Object execute(SymbolsTable globalSymTable, SymbolsTable symTable, KeywordLibrariesRepository libraryKeywordsRepository) throws Exception {
        throw new Exception("Not implemented");
    }
}
