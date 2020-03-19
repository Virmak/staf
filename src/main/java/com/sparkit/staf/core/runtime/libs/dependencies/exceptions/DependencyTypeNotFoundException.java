package com.sparkit.staf.core.runtime.libs.dependencies.exceptions;

public class DependencyTypeNotFoundException extends Exception {
    public DependencyTypeNotFoundException(Class<?> type) {
        super("No object with type : " + type.toString() + " is registered");
    }
}
