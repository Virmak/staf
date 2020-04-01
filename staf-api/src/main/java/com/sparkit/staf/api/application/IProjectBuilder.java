package com.sparkit.staf.api.application;

import com.sparkit.staf.api.application.exception.ProjectNameAlreadyExist;
import com.sparkit.staf.api.models.ProjectConfig;
import com.sparkit.staf.api.models.request.CreateProjectRequest;

import java.io.IOException;

public interface IProjectBuilder {
    ProjectConfig build(CreateProjectRequest createProjectRequest) throws IOException, ProjectNameAlreadyExist;
}
