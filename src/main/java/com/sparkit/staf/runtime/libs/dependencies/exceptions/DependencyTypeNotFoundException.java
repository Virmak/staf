package com.sparkit.staf.runtime.libs.dependencies.exceptions;

public class DependencyTypeNotFoundException extends Exception {
    public DependencyTypeNotFoundException(Class<?> type) {
        super("No object with type : " + type.toString() + " is registered");
    }
}
