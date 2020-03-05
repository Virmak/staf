package com.sparkit.staf.runtime.libs;

import com.sparkit.staf.ast.types.KeywordCall;
import com.sparkit.staf.ast.types.AbstractStafObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeywordWrapper {
    private AbstractStafLibrary libInstance;
    private Method method;

    public KeywordWrapper(AbstractStafLibrary libInstance, Method method) {
        this.libInstance = libInstance;
        this.method = method;
    }


    public Object invoke(Object[] params) throws InvocationTargetException, IllegalAccessException {
        List<Object> paramsList = Arrays.asList(params);
        Object[] methodParams = new Object[method.getParameterCount()]; // match the number of params in the method
        for (int i = 0; i < method.getParameterCount(); i++) {
            if (i < params.length) {
                methodParams[i] = params[i];
            } else break;
        }
        return method.invoke(libInstance, methodParams);
    }
}
