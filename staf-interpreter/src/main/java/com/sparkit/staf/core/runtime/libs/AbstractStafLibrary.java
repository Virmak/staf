package com.sparkit.staf.core.runtime.libs;

import com.sparkit.staf.core.runtime.loader.TestContainer;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractStafLibrary {
    @Autowired
    protected TestContainer container;
    protected String libraryName;
    protected LibType type;
    protected Map<String, Method> keywordMethodsMap;

    public AbstractStafLibrary() {
        keywordMethodsMap = new HashMap<>();
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

    protected Class<? extends AbstractStafLibrary> getClassName() {
        return getClass();
    }
}
