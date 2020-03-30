package com.sparkit.staf.api.models;

public enum FileType {
    FILE("scroll"),
    DIRECTORY("folder"),
    TestSuite("test_suite")
    ;
    public final String label;

    FileType(String label) {
        this.label = label;
    }
}