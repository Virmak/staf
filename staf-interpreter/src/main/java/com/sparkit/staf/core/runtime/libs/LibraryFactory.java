package com.sparkit.staf.core.runtime.libs;

import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
import com.sparkit.staf.core.runtime.loader.TestContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service
public class LibraryFactory {
    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    public AbstractStafLibrary build(Class<? extends AbstractStafLibrary> libraryClass, TestContainer container)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
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
