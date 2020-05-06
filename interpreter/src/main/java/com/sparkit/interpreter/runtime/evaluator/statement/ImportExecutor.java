package com.sparkit.interpreter.runtime.evaluator.statement;

import com.sparkit.interpreter.compiler.ast.ImportTypes;
import com.sparkit.interpreter.compiler.ast.statement.ImportStatement;
import com.sparkit.interpreter.compiler.ast.types.AbstractStafObject;
import com.sparkit.interpreter.runtime.StafFileLoader;
import com.sparkit.interpreter.runtime.SymbolsTable;
import com.sparkit.interpreter.runtime.libs.AbstractStafLibrary;
import com.sparkit.interpreter.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.interpreter.runtime.libs.LibraryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Map;

@Component
public class ImportExecutor {
    @Autowired
    private LibraryFactory libraryFactory;
    @Autowired
    private KeywordLibrariesRepository keywordLibrariesRepository;
    @Autowired
    private StafFileLoader stafFileLoader;

    public void execute(ImportStatement statement, String currentDirectory) throws Throwable {
        Map<String, Class<? extends AbstractStafLibrary>> librariesClassesMap = libraryFactory.getBuiltinLibrariesClasses();
        if (statement.getType() == ImportTypes.BUILT_IN_LIBRARY) {
            String libClassName = statement.getPath().substring(0, 1).toUpperCase()
                    + statement.getPath().toLowerCase().substring(1) + "Library";
            keywordLibrariesRepository.registerLibrary(librariesClassesMap.get(libClassName));
        } else {
            File directory = new File(currentDirectory);
            File b = new File(directory, statement.getPath().replaceAll("[\"']", ""));
            String absolute = b.getCanonicalPath(); // may throw IOException
            stafFileLoader.load(absolute);
        }
    }
}
