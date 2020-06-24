package com.sparkit.staf.core.runtime.libs.builtin.selenium.exceptions;

public class ElementShouldBeEnabledException extends SeleniumLibException {
    public ElementShouldBeEnabledException(String element) {
        super("Element : " + element + " should be enabled");
    }
}
