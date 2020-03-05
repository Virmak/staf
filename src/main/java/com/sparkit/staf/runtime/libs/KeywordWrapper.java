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
        /* refactor this -- calling builtin keyword with actual data instead of StafObject --> make   */
        List<Object> paramsList = Arrays.asList(params);
        Object[] methodParams = new Object[method.getParameterCount()]; // match the number of params in the method
        for (int i = 0; i < method.getParameterCount(); i++) {
            if (i < params.length) {
                methodParams[i] = params[i];
            } else break;
        }
        /*for (Object param : params) {
            if (param instanceof KeywordCall) {
                paramsList.add(param);
            } else if (param instanceof AbstractStafObject) {
                AbstractStafObject stafObject = (AbstractStafObject) param;
                paramsList.add(stafObject.getValue());
            }
        }
        int methodParamsCount = method.getParameterCount();
        if (paramsList.size() < methodParamsCount) {
            for (int i = paramsList.size(); i < methodParamsCount; i++) {
                paramsList.add(null);
            }
        }*/
        return method.invoke(libInstance, methodParams);
    }
}
