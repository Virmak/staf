package com.sparkit.staf.runtime.libs.builtin.selenium.exceptions;

import com.sparkit.staf.runtime.libs.exceptions.AbstractStafLibraryException;

public class UnsupportedBrowserDriverException extends AbstractStafLibraryException {
    public UnsupportedBrowserDriverException(String browser) {
        super("Unsupported browser '" + browser + "' driver");
    }
}
