package com.sparkit.staf.core.runtime.libs.builtin.selenium.exceptions;

public class ElementShouldBeVisibleNotFoundException extends SeleniumLibException {
    public ElementShouldBeVisibleNotFoundException(String element) {
        super("Element : " + element + " should be visible but was not found");
    }
}
