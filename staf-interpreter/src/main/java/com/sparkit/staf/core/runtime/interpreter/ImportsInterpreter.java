package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.ImportStatement;
import com.sparkit.staf.core.ast.ImportTypes;
import com.sparkit.staf.core.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
import com.sparkit.staf.core.runtime.loader.IStafScriptBuilder;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImportsInterpreter {
    public final String libsPackage = "com.sparkit.staf.core.runtime.libs.builtin";
    private final IStafScriptBuilder scriptBuilder;
    private final KeywordLibrariesRepository keywordsRepository;
    private final String testsDirectory;

    public ImportsInterpreter(IStafScriptBuilder scriptBuilder, KeywordLibrariesRepository keywordsRepository, String testDirectory) {
        this.scriptBuilder = scriptBuilder;
        this.keywordsRepository = keywordsRepository;
        this.testsDirectory = testDirectory;
    }

    /* Load imports */
    public void loadImports(List<ImportStatement> importStatements, String currentDirectory) throws Throwable {
        Map<String, Class<? extends AbstractStafLibrary>> librariesClassesMap = getBuiltinLibrariesClasses();
        for (ImportStatement statement : importStatements) {
            if (statement.getType() == ImportTypes.BUILT_IN_LIBRARY) {
                String libClassName = statement.getPath().substring(0, 1).toUpperCase()
                        + statement.getPath().toLowerCase().substring(1) + "Library";
                keywordsRepository.registerLibrary(librariesClassesMap.get(libClassName));
            } else {
                File directory = new File(currentDirectory);
                File b = new File(directory, statement.getPath().replaceAll("[\"']", ""));
                String absolute = b.getCanonicalPath(); // may throw IOException
                scriptBuilder.load(absolute, this);
            }
        }
    }

    /* Search for builtin library classes using reflections */
    private Map<String, Class<? extends AbstractStafLibrary>> getBuiltinLibrariesClasses() {
        try (ScanResult result = new ClassGraph().enableClassInfo().enableAnnotationInfo()
                .whitelistPackages(libsPackage).scan()) {

            ClassInfoList classInfos = result.getClassesWithAnnotation(StafLibrary.class.getName());
            List<Class<?>> librariesClasses = classInfos.loadClasses();
            Map<String, Class<? extends AbstractStafLibrary>> classMap = new HashMap<>();
            for (Class<?> libClass : librariesClasses) {
                classMap.put(libClass.getSimpleName(), (Class<? extends AbstractStafLibrary>) libClass);
            }
            return classMap;
        }
    }

    public String getTestsDirectory() {
        return testsDirectory;
    }
}
