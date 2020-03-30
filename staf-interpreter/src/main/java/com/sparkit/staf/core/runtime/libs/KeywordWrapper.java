package com.sparkit.staf.core.runtime.libs;

import com.sparkit.staf.core.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class KeywordWrapper {
    private static final Logger LOG = LogManager.getLogger(Main.class);
    private AbstractStafLibrary libInstance;
    private Method method;

    public KeywordWrapper(AbstractStafLibrary libInstance, Method method) {
        this.libInstance = libInstance;
        this.method = method;
    }


    public Object invoke(Object[] params) throws Throwable {
        List<Object> paramsList = Arrays.asList(params);
        Object[] methodParams = new Object[method.getParameterCount()]; // match the number of params in the method
        for (int i = 0; i < method.getParameterCount(); i++) {
            if (i < params.length) {
                methodParams[i] = params[i];
            } else break;
        }
        try {
            return method.invoke(libInstance, methodParams);
        }  catch (InvocationTargetException ex) {
            System.err.println("An InvocationTargetException was caught!");
            Throwable cause = ex.getCause();
            LOG.error(String.format("Invocation of %s failed because of: %s%n",
                    method.getName(), cause.getMessage()));
            throw ex.getCause();
        }
    }
}
