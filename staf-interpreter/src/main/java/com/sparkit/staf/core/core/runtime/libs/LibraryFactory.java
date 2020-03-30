package com.sparkit.staf.core.runtime.libs;

import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
<<<<<<< HEAD:staf-interpreter/src/main/java/com/sparkit/staf/core/core/runtime/libs/LibraryFactory.java
import com.sparkit.staf.core.runtime.libs.dependencies.DependencyContainer;
=======
import com.sparkit.staf.core.runtime.loader.TestContainer;
>>>>>>> 7a82d8117d101f54165fa8a08889696c97e79217:staf-interpreter/src/main/java/com/sparkit/staf/core/runtime/libs/LibraryFactory.java

import java.lang.reflect.InvocationTargetException;

public class LibraryFactory {
    public static AbstractStafLibrary build(Class<? extends AbstractStafLibrary> libraryClass, TestContainer container)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        StafLibrary libraryClassAnnotation = libraryClass.getAnnotation(StafLibrary.class);


        AbstractStafLibrary libraryInstance = (AbstractStafLibrary) libraryClass.getConstructors()[0].newInstance(container);
        libraryInstance.setLibraryName(libraryClassAnnotation.name());
        if (libraryClassAnnotation.builtin()) {
            libraryInstance.setType(LibType.BUILT_IN);
        } else {
            libraryInstance.setType(LibType.USER_DEFINED);
        }
        return libraryInstance;
    }
}
