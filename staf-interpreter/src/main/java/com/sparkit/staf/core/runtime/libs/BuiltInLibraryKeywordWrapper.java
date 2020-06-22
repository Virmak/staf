package com.sparkit.staf.core.runtime.libs;


import com.sparkit.staf.core.Main;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BuiltInLibraryKeywordWrapper {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    @Getter
    private final AbstractStafLibrary libInstance;
    private final Method method;

    public BuiltInLibraryKeywordWrapper(AbstractStafLibrary libInstance, Method method) {
        this.libInstance = libInstance;
        this.method = method;
    }


    public Object invoke(Object[] params, Object webDriver) throws Throwable {//TODO: Refactor
        Object[] methodParams = new Object[method.getParameterCount()]; // match the number of params in the method
        if (webDriver != null) {
            methodParams[0] = webDriver;
            for (int i = 1; i < method.getParameterCount() + 1; i++) {
                if (i < params.length + 1) {
                    methodParams[i] = params[i - 1];
                } else break;
            }
        } else {
            for (int i = 0; i < method.getParameterCount(); i++) {
                if (i < params.length) {
                    methodParams[i] = params[i];
                } else break;
            }
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
}
