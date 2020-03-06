package com.sparkit.staf.runtime.libs.builtin.selenium.exceptions;

public class ElementShouldBeVisibleNotFoundException extends Exception {
    public ElementShouldBeVisibleNotFoundException(String element) {
        super("Element : " + element  + " should be visible but was not found" );
    }
}
