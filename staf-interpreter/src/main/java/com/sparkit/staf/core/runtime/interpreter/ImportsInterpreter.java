package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.ImportStatement;
import com.sparkit.staf.core.ast.ImportTypes;
import com.sparkit.staf.core.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.core.runtime.libs.BuiltInLibraryFactory;
import com.sparkit.staf.core.runtime.loader.IStafScriptLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;
import java.util.Map;

@Component
public class ImportsInterpreter implements IImportsInterpreter {
    @Autowired
    private IStafScriptLoader scriptBuilder;
    @Autowired
    private BuiltInLibraryFactory libraryFactory;

    /* Load imports */
    public void loadImports(List<ImportStatement> importStatements, TestSuite testSuite, String currentDirectory, String testDirectory) throws Throwable {
        Map<String, Class<? extends AbstractStafLibrary>> librariesClassesMap = libraryFactory.getBuiltinLibrariesClasses();
        for (ImportStatement statement : importStatements) {
            if (statement.getType() == ImportTypes.BUILT_IN_LIBRARY) {
                String libClassName = statement.getPath().substring(0, 1).toUpperCase()
                        + statement.getPath().toLowerCase().substring(1) + "Library";
                testSuite.getKeywordLibrariesRepository().registerLibrary(librariesClassesMap.get(libClassName));
            } else {
                File directory = new File(currentDirectory);
                File importedFile = new File(directory, statement.getPath().replaceAll("[\"']", ""));
                String importedFileAbsolutePath = importedFile.getCanonicalPath(); // may throw IOException
                scriptBuilder.load(testSuite, importedFileAbsolutePath);
            }
        }
    }
}
