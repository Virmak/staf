package com.sparkit.staf.runtime.libs.builtin.webservice.exceptions;

import com.sparkit.staf.runtime.libs.exceptions.AbstractStafLibraryException;

public class WebServiceTestFailedException extends AbstractStafLibraryException {
    public WebServiceTestFailedException(String path, String message) {
        super("Test for : (" + path + ") failed \n" + message);
    }
}
