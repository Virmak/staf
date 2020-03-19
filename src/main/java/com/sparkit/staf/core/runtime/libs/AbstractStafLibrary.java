package com.sparkit.staf.core.runtime.libs;

import com.sparkit.staf.core.runtime.libs.annotations.Keyword;
import com.sparkit.staf.core.runtime.libs.dependencies.DependencyContainer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractStafLibrary {
    protected final DependencyContainer container;
    protected String libraryName;
    protected LibType type;
    protected Map<String, Method> keywordMethodsMap;

    public AbstractStafLibrary(DependencyContainer container) {
        this.container = container;
        keywordMethodsMap = new HashMap<>();
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public LibType getType() {
        return type;
    }

    public void setType(LibType type) {
        this.type = type;
    }

    public Object callKeyword(String keyword, Object[] params) throws InvocationTargetException, IllegalAccessException {
        for (Method method : getClassName().getMethods()) {
            Keyword keywordAnnotation = method.getAnnotation(Keyword.class);
            if (keywordAnnotation != null
                    && keywordAnnotation.name().toLowerCase().equals(keyword.toLowerCase())) {
                return method.invoke(this, params);
            }
        }
        return null;
    }

    protected Class<? extends AbstractStafLibrary> getClassName() {
        return getClass();
    }
}
