package com.sparkit.staf.core.runtime.libs.builtin.selenium;

public enum Browser {
    CHROME ("chrome"),
    FIREFOX ("firefox"),
    OPERA ("opera");

    private final String name;

    Browser(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
