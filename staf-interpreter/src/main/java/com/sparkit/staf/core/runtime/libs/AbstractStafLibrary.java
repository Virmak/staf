package com.sparkit.staf.core.runtime.libs;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractStafLibrary {
    @Setter
    @Getter
    protected String libraryName;
    @Getter
    @Setter
    protected LibType type;
    protected Map<String, Method> keywordMethodsMap;

    public AbstractStafLibrary() {
        keywordMethodsMap = new HashMap<>();
    }

    protected Class<? extends AbstractStafLibrary> getClassName() {
        return getClass();
    }
}
