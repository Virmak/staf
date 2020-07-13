package com.sparkit.staf.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties
public class ProjectConfig {
    private int id;
    private String project;
    private String description;
    private String location;
    private String logDir;
    private String reportsDir;
    private ProjectType type;
    private List<String> testSuites;
}
