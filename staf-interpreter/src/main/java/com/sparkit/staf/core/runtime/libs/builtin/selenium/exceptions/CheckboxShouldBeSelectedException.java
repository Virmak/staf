package com.sparkit.staf.core.runtime.libs.builtin.selenium.exceptions;

public class CheckboxShouldBeSelectedException extends SeleniumLibException {
    public CheckboxShouldBeSelectedException(String element) {
        super("Checkbox with locator : " + element + " should be selected failed");
    }
}
