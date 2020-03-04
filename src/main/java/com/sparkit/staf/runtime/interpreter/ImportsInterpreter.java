package com.sparkit.staf.runtime.interpreter;

import com.sparkit.staf.ast.ImportStatement;
import com.sparkit.staf.ast.ImportTypes;
import com.sparkit.staf.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.runtime.libs.annotations.StafLibrary;
import com.sparkit.staf.runtime.loader.IStafScriptBuilder;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImportsInterpreter {
    public final String libsPackage = "com.sparkit.staf.runtime.libs.builtin";
    private final IStafScriptBuilder scriptBuilder;
    private final KeywordLibrariesRepository keywordsRepository;

    public ImportsInterpreter(IStafScriptBuilder scriptBuilder, KeywordLibrariesRepository keywordsRepository) {
        this.scriptBuilder = scriptBuilder;
        this.keywordsRepository = keywordsRepository;
    }

    /* Load imports */
    public void loadImports(List<ImportStatement> importStatements) throws Exception {
        Map<String, Class<? extends AbstractStafLibrary>> librariesClassesMap = getBuiltinLibrariesClasses();
        for (ImportStatement statement : importStatements) {
            if (statement.getType() == ImportTypes.BUILT_IN_LIBRARY) {
                String libClassName = statement.getPath().substring(0, 1).toUpperCase()
                        + statement.getPath().toLowerCase().substring(1) + "Library";
                keywordsRepository.registerLibrary(librariesClassesMap.get(libClassName));
            } else {
                String filePath = statement.getPath().replaceAll("\"", "");
                if (!filePath.contains(".staf")) { // add check to .py files
                    filePath = filePath + ".staf";
                }
                scriptBuilder.load(filePath, this);
            }
        }
    }

    /* Search for builtin library classes using reflections */
    private Map<String, Class<? extends AbstractStafLibrary>> getBuiltinLibrariesClasses() {
        Reflections ref = new Reflections(libsPackage);
        Set<Class<?>> librariesClasses = ref.getTypesAnnotatedWith(StafLibrary.class);
        Map<String, Class<? extends AbstractStafLibrary>> classMap = new HashMap<>();
        for (Class<?> libClass : librariesClasses) {
            classMap.put(libClass.getSimpleName(), (Class<? extends AbstractStafLibrary>) libClass);
        }
        return classMap;
    }
}
