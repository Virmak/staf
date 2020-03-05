package com.sparkit.staf.runtime.libs.builtin.selenium.exceptions;

public class UnsupportedBrowserDriverException extends Exception {
    public UnsupportedBrowserDriverException(String browser) {
        super("Unsupported browser '" + browser + "' driver");
    }
}