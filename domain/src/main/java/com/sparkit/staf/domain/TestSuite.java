package com.sparkit.staf.domain;


import lombok.Data;

@Data
public class TestSuite {
    private int id;
    private String name;
    private String description;
    private String rootPath;
    private boolean enabled;
}
