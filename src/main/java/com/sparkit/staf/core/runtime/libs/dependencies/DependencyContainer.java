package com.sparkit.staf.core.runtime.libs.dependencies;

import com.sparkit.staf.core.runtime.libs.dependencies.exceptions.DependencyTypeNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class DependencyContainer {
    Map<Class<?>, Object> dependencies = new HashMap<>();

    public DependencyContainer() {}

    public void register(Object obj) {
        dependencies.put(obj.getClass(), obj);
    }

    public Object getDependency(Class<?> type) throws DependencyTypeNotFoundException {
        if (!dependencies.containsKey(type)) {
            throw new DependencyTypeNotFoundException(type);
        }
        return dependencies.get(type);
    }
}
