package com.sparkit.staf.domain;

import lombok.Data;

import java.util.List;

@Data
public class Project {
    private int id;
    private String name;
    private String description;
    private String rootPath;
    private String logDir;
    private String reportsDir;
    private ProjectType type;
    private List<TestSuite> testSuites;
}
