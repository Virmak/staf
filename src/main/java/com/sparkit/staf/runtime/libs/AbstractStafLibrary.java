package com.sparkit.staf.runtime.libs;

import com.sparkit.staf.runtime.libs.annotations.Keyword;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractStafLibrary {
    protected String libraryName;
    protected LibType type;
    protected Map<String, Method> keywordMethodsMap;

    public AbstractStafLibrary() {
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
        for (Method method: getClassName().getMethods()) {
            Keyword keywordAnnotation = method.getAnnotation(Keyword.class);
            if (keywordAnnotation != null
                    && keywordAnnotation.name().toLowerCase().equals(keyword.toLowerCase())) {
                return method.invoke(this, params);
            }
        }
        return null;
    }

    protected abstract Class<? extends AbstractStafLibrary> getClassName();
}
