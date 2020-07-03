package com.sparkit.staf.application;

import com.sparkit.staf.application.exception.ProjectNameAlreadyExist;
import com.sparkit.staf.application.models.request.CreateProjectRequest;
import com.sparkit.staf.application.models.request.CreateTestSuiteRequest;
import com.sparkit.staf.domain.ProjectConfig;
import com.sparkit.staf.domain.TestSuite;

import java.io.File;
import java.io.IOException;

public interface IProjectBuilder {
    ProjectConfig buildProject(CreateProjectRequest createProjectRequest) throws IOException, ProjectNameAlreadyExist;
    TestSuite buildTestSuite(CreateTestSuiteRequest createTestSuiteRequest) throws IOException;
    void writeConfigFile(ProjectConfig config, File projectDir) throws IOException;
}
