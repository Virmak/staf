package com.sparkit.staf.runtime.interpreter;

import com.sparkit.staf.ast.ImportStatement;
import com.sparkit.staf.ast.ImportTypes;
import com.sparkit.staf.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.runtime.libs.exceptions.LibraryNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImportsInterpreter {
    private List<ImportStatement> importStatements;
    private final KeywordLibrariesRepository keywordsRepository;
    private Map<String, AbstractStafLibrary> libraryMap;
    public final String libsPackage = "com.sparkit.staf.runtime.libs.builtin";

    public ImportsInterpreter(List<ImportStatement> importStatements, KeywordLibrariesRepository keywordsRepository) {
        this.importStatements = importStatements;
        this.keywordsRepository = keywordsRepository;
        libraryMap = new HashMap<>();
    }

    public void loadFiles() throws Exception {
        for (ImportStatement statement: importStatements) {
            if (statement.getType() == ImportTypes.BUILT_IN_LIBRARY) {
                String libClassName = libsPackage + "." + statement.getPath().substring(0, 1).toUpperCase()
                        +  statement.getPath().toLowerCase().substring(1) + "Library";
                try {
                    keywordsRepository.registerLibrary((Class<? extends AbstractStafLibrary>)Class.forName(libClassName));
                } catch (ClassNotFoundException e) {
                    throw new LibraryNotFoundException();
                }
            } else {
                throw new Exception("user defined libs not implemented");
            }
        }
    }

    public AbstractStafLibrary getLibraryByName(String name) {
        return libraryMap.get(name);
    }

}
