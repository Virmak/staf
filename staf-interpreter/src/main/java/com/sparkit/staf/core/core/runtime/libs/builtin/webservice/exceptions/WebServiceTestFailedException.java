package com.sparkit.staf.core.runtime.libs.builtin.webservice.exceptions;

import com.sparkit.staf.core.runtime.libs.exceptions.AbstractStafLibraryException;

public class WebServiceTestFailedException extends AbstractStafLibraryException {
    public WebServiceTestFailedException(String path, String message) {
        super("Test for : (" + path + ") failed \n" + message);
    }
}
