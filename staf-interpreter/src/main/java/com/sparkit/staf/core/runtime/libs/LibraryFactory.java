package com.sparkit.staf.core.runtime.libs;

import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
import com.sparkit.staf.core.runtime.loader.TestContainer;

import java.lang.reflect.InvocationTargetException;

public class LibraryFactory {
    public static AbstractStafLibrary build(Class<? extends AbstractStafLibrary> libraryClass, TestContainer container)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        StafLibrary libraryClassAnnotation = libraryClass.getAnnotation(StafLibrary.class);
        AbstractStafLibrary libraryInstance = (AbstractStafLibrary) libraryClass.getConstructors()[0].newInstance();
        libraryInstance.setLibraryName(libraryClassAnnotation.name());
        if (libraryClassAnnotation.builtin()) {
            libraryInstance.setType(LibType.BUILT_IN);
        } else {
            libraryInstance.setType(LibType.USER_DEFINED);
        }
        return libraryInstance;
    }
}