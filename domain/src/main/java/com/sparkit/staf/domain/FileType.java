package com.sparkit.staf.domain;

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