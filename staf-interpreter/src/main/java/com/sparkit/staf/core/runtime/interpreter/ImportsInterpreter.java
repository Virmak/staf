package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.ImportStatement;
import com.sparkit.staf.core.ast.ImportTypes;
import com.sparkit.staf.core.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.core.runtime.libs.KeywordLibrariesRepository;
import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
import com.sparkit.staf.core.runtime.loader.IStafScriptLoader;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ImportsInterpreter implements IImportsInterpreter {
    public final String libsPackage = "com.sparkit.staf.core.runtime.libs.builtin";
    @Autowired
    private IStafScriptLoader scriptBuilder;
    @Autowired
    private KeywordLibrariesRepository keywordsRepository;


    /* Load imports */
    public void loadImports(List<ImportStatement> importStatements, String currentDirectory, String testDirectory) throws Throwable {
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
                scriptBuilder.load(absolute);
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
}
