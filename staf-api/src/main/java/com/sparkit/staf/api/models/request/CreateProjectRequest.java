package com.sparkit.staf.api.models.request;

import com.sparkit.staf.api.domain.ProjectType;
import lombok.Data;

@Data
public class CreateProjectRequest {
    private int id;
    private String name;
    private String description;
    private String location;
    private String logDir;
    private String reportsDir;
    private ProjectType type;
}