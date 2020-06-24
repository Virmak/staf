package com.sparkit.staf.core.runtime.libs;

import com.sparkit.staf.core.Main;
import com.sparkit.staf.core.runtime.libs.annotations.Inject;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class BuiltInLibraryKeywordWrapper {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    @Getter
    private final AbstractStafLibrary libInstance;
    private final Method method;

    public BuiltInLibraryKeywordWrapper(AbstractStafLibrary libInstance, Method method) {
        this.libInstance = libInstance;
        this.method = method;
    }

    public Object invoke(List<Object> paramsList) throws Throwable {
        Object[] parametersArray = new Object[paramsList.size()];
        paramsList.toArray(parametersArray);
        return invoke(parametersArray);
    }
    public Object invoke(Object[] params) throws Throwable {//TODO: Refactor
        Object[] methodParams = new Object[method.getParameterCount()]; // match the number of params in the method
        for (int i = 0; i < method.getParameterCount(); i++) {
            if (i < params.length) {
                methodParams[i] = params[i];
            } else break;
        }
        try {
            return method.invoke(libInstance, methodParams);
        } catch (InvocationTargetException ex) {
            System.err.println("An InvocationTargetException was caught!");
            Throwable cause = ex.getCause();
            logger.error(String.format("Invocation of %s failed because of: %s%n",
                    method.getName(), cause.getMessage()));
            throw ex.getCause();
        }
    }

    public List<String> getInjectAnnotatedParams() {
        List<String> annotatedParams = new ArrayList<>();
        for (Parameter parameter : method.getParameters()) {
            if (parameter.isAnnotationPresent(Inject.class)) {
                Inject annotation = parameter.getAnnotation(Inject.class);
                annotatedParams.add(annotation.name());
            }
        }
        return annotatedParams;
    }
}
