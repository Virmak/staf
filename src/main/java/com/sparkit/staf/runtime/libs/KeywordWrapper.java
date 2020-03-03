package com.sparkit.staf.runtime.libs;

import com.sparkit.staf.ast.StafObject;
import com.sparkit.staf.runtime.libs.AbstractStafLibrary;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class KeywordWrapper {
    private AbstractStafLibrary libInstance;
    private Method method;

    public KeywordWrapper(AbstractStafLibrary libInstance, Method method)  {
        this.libInstance = libInstance;
        this.method = method;
    }

    public Object invoke(Object[] params) throws InvocationTargetException, IllegalAccessException {
        Object[] paramsArray = new Object[params.length];
        for (int i = 0; i < params.length; i++) {
            if (params[i] instanceof StafObject) {
                StafObject stafObject = (StafObject)params[i];
                paramsArray[i] = stafObject.getValue();
            }
        }
        return method.invoke(libInstance, paramsArray);
    }
}
