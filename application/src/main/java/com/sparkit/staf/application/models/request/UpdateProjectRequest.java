package com.sparkit.staf.application.models.request;

import lombok.Data;

@Data
public class UpdateProjectRequest {
    private String oldProjectName;
    private String newProjectName;
    private String description;
}
