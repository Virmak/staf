package com.sparkit.staf.runtime.interpreter;

import com.sparkit.staf.ast.ImportStatement;
import com.sparkit.staf.ast.ImportTypes;
import com.sparkit.staf.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.runtime.libs.annotations.StafLibrary;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        Map<String, Class<? extends AbstractStafLibrary>> librariesClassesMap = getLibrariesClasses();
        for (ImportStatement statement: importStatements) {
            if (statement.getType() == ImportTypes.BUILT_IN_LIBRARY) {
                String libClassName = statement.getPath().substring(0, 1).toUpperCase()
                        +  statement.getPath().toLowerCase().substring(1) + "Library";
                keywordsRepository.registerLibrary(librariesClassesMap.get(libClassName));
            } else {
                throw new Exception("user defined libs not implemented");
            }
        }
    }

    private Map<String, Class<? extends AbstractStafLibrary>> getLibrariesClasses() {
        Reflections ref = new Reflections(libsPackage);
        Set<Class<?>> librariesClasses = ref.getTypesAnnotatedWith(StafLibrary.class);
        Map<String, Class<? extends AbstractStafLibrary>> classMap = new HashMap<>();
        for (Class<?> libClass : librariesClasses) {
            classMap.put(libClass.getSimpleName(), (Class<? extends AbstractStafLibrary>) libClass);
        }
        return classMap;
    }


    public AbstractStafLibrary getLibraryByName(String name) {
        return libraryMap.get(name);
    }

}
