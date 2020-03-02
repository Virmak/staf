package com.sparkit.staf.runtime.libs;

import com.sparkit.staf.runtime.libs.annotations.StafLibrary;
import java.lang.reflect.InvocationTargetException;

public class LibraryFactory {
    public static AbstractStafLibrary build(Class<? extends AbstractStafLibrary> libraryClass)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        StafLibrary libraryClassAnnotation = libraryClass.getAnnotation(StafLibrary.class);

        AbstractStafLibrary libraryInstance = libraryClass.getDeclaredConstructor().newInstance();
        libraryInstance.setLibraryName(libraryClassAnnotation.name());
        if (libraryClassAnnotation.builtin()) {
            libraryInstance.setType(LibType.BUILT_IN);
        } else {
            libraryInstance.setType(LibType.USER_DEFINED);
        }
        return libraryInstance;
    }
}
