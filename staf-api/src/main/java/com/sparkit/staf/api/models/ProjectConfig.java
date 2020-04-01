package com.sparkit.staf.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sparkit.staf.api.domain.ProjectType;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties
public class ProjectConfig {
    private int id;
    private String project;
    private String description;
    private String rootPath;
    private String logDir;
    private String reportsDir;
    private ProjectType type;
    private List<String> testSuites;
}
