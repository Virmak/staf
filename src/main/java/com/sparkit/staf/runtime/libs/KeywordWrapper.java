package com.sparkit.staf.runtime.libs;

import com.sparkit.staf.ast.KeywordCall;
import com.sparkit.staf.ast.StafObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
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
        List<Object> paramsList = new ArrayList<>();
        for (int i = 0; i < params.length; i++) {
            if (params[i] instanceof KeywordCall) {
                paramsList.add(params[i]);
            } else if (params[i] instanceof StafObject) {
                StafObject stafObject = (StafObject) params[i];
                paramsList.add(stafObject.getValue());
            }
        }
        int methodParamsCount = method.getParameterCount();
        if (paramsList.size() < methodParamsCount) {
            for (int i = paramsList.size(); i < methodParamsCount; i++) {
                paramsList.add(null);
            }
        }
        return method.invoke(libInstance, paramsList.toArray());
    }
}
