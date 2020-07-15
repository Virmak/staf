package com.sparkit.staf.core.runtime.libs;

import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
import com.sparkit.staf.core.runtime.libs.exceptions.LibraryNotFoundException;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BuiltInLibraryFactory {
    public static final String LIBS_PACKAGE = "com.sparkit.staf.core.runtime.libs.builtin";

    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    public AbstractStafLibrary build(Class<? extends AbstractStafLibrary> libraryClass)
            throws IllegalAccessException, InvocationTargetException, InstantiationException {
        if (libraryClass == null) {
            throw new LibraryNotFoundException("Library not found");
        }
        StafLibrary libraryClassAnnotation = libraryClass.getAnnotation(StafLibrary.class);
        AbstractStafLibrary libraryInstance = (AbstractStafLibrary) libraryClass.getConstructors()[0].newInstance();
        autowireCapableBeanFactory.autowireBean(libraryInstance);
        libraryInstance.setLibraryName(libraryClassAnnotation.name());
        if (libraryClassAnnotation.builtin()) {
            libraryInstance.setType(LibType.BUILT_IN);
        } else {
            libraryInstance.setType(LibType.USER_DEFINED);
        }
        return libraryInstance;
    }

    /* Search for builtin library classes using reflections */
    public Map<String, Class<? extends AbstractStafLibrary>> getBuiltinLibrariesClasses() {
        try (ScanResult result = new ClassGraph().enableClassInfo().enableAnnotationInfo()
                .whitelistPackages(LIBS_PACKAGE).scan()) {

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
