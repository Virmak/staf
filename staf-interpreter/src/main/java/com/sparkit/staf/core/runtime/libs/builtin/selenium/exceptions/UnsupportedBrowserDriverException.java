package com.sparkit.staf.core.runtime.libs.builtin.selenium.exceptions;

import com.sparkit.staf.core.runtime.libs.exceptions.AbstractStafLibraryException;

public class UnsupportedBrowserDriverException extends AbstractStafLibraryException {
    public UnsupportedBrowserDriverException(String browser) {
        super("Unsupported browser '" + browser + "' driver");
    }
}
