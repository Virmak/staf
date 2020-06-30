package com.sparkit.staf.core.ast;

import com.sparkit.staf.core.runtime.interpreter.SymbolsTable;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import lombok.Data;

@Data
public class ImportStatement implements IStatement {
    private String path;
    private ImportTypes type;

    public ImportStatement(String path) {
        this.path = path;
        this.resolveType();
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
    public Object execute(SymbolsTable globalSymbolsTable, SymbolsTable localSymbolsTable, KeywordLibrariesRepository keywordLibrariesRepository) throws Throwable {
        return null;
    }
}
