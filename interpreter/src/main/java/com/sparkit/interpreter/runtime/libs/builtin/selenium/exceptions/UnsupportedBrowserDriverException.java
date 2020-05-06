package com.sparkit.interpreter.runtime.libs.builtin.selenium.exceptions;

public class UnsupportedBrowserDriverException extends SeleniumLibException {
    public UnsupportedBrowserDriverException(String browser) {
        super("Unsupported browser '" + browser + "' driver");
    }
}
