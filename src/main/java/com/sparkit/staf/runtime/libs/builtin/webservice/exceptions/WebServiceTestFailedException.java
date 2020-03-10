package com.sparkit.staf.runtime.libs.builtin.webservice.exceptions;

public class WebServiceTestFailedException extends Exception {
    public WebServiceTestFailedException(String path, String message) {
        super("Test for : (" + path + ") failed \n" + message);
    }
}
