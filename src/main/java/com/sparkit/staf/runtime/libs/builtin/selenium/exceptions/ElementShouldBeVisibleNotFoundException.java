package com.sparkit.staf.runtime.libs.builtin.selenium.exceptions;

import com.sparkit.staf.runtime.libs.exceptions.AbstractStafLibraryException;

public class ElementShouldBeVisibleNotFoundException extends AbstractStafLibraryException {
    public ElementShouldBeVisibleNotFoundException(String element) {
        super("Element : " + element  + " should be visible but was not found" );
    }
}
