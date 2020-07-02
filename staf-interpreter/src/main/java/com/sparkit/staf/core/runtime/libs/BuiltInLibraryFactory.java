package com.sparkit.staf.core.runtime.libs;

import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service
public class BuiltInLibraryFactory {
    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    public AbstractStafLibrary build(Class<? extends AbstractStafLibrary> libraryClass)
            throws IllegalAccessException, InvocationTargetException, InstantiationException {
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
}
