package com.sparkit.staf.api.application;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sparkit.staf.api.application.exception.ProjectNameAlreadyExist;
import com.sparkit.staf.api.domain.ProjectType;
import com.sparkit.staf.api.models.ProjectConfig;
import com.sparkit.staf.api.models.request.CreateProjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

@Component
public class ProjectBuilder implements IProjectBuilder {
    private ObjectMapper mapper = new ObjectMapper();

    @Value("${testDirectory}")
    private String testDir;

    @Override
    public ProjectConfig build(CreateProjectRequest createProjectRequest) throws IOException, ProjectNameAlreadyExist {
        ProjectConfig config = getJsonResourceFile("config_template.json");
        config.setProject(createProjectRequest.getName());
        config.setDescription(createProjectRequest.getDescription());
        config.setLogDir(createProjectRequest.getLogDir());
        config.setReportsDir(createProjectRequest.getReportsDir());
        config.setType(createProjectRequest.getType());
        config.setTestSuites(new ArrayList<>());
        File projectDir = new File(testDir, normalizeProjectName(createProjectRequest.getName()));
        if (projectDir.exists()) {
            throw new ProjectNameAlreadyExist();
        } else {
            projectDir.mkdir();
            createConfigFile(config, projectDir);
            if (createProjectRequest.getType() == ProjectType.UITest) {
                createUITestSuite("UI test suite", config, projectDir);
            } else if (createProjectRequest.getType() == ProjectType.APITest) {
                createAPITestSuite("API test suite", config, projectDir);
            }
        }
        return config;
    }

    private void createConfigFile(ProjectConfig config, File projectDir) throws IOException {
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File(projectDir, "config.json"), config);
    }

    private void createUITestSuite(String testSuiteName, ProjectConfig config, File projectDir) throws IOException {
        File testSuiteDir = new File(projectDir, testSuiteName);
        testSuiteDir.mkdir();
        File pagesDir = new File(testSuiteDir, "pages");
        File stepsDir = new File(testSuiteDir, "steps");
        File mainFile = new File(testSuiteDir, "main.staf");
        mainFile.createNewFile();
        pagesDir.mkdir();
        stepsDir.mkdir();
        config.getTestSuites().add(testSuiteName);
    }

    private void createAPITestSuite(String testSuiteName, ProjectConfig config, File projectDir) throws IOException { // Create structure for API Testing project
        File testSuiteDir = new File(projectDir, testSuiteName);
        testSuiteDir.mkdir();
        File requestsDir = new File(testSuiteDir, "requests");
        requestsDir.mkdir();
        File mainFile = new File(testSuiteDir, "main.staf");
        mainFile.createNewFile();
        config.getTestSuites().add(testSuiteName);
    }

    private ProjectConfig getJsonResourceFile(String filename) throws IOException {
        URL resource = getClass().getClassLoader().getResource(filename);
        File file = new File(resource.getPath());
        return mapper.readValue(file, ProjectConfig.class);
    }

    private boolean createDir(String dirName) {
        File dir = new File(dirName);
        return dir.mkdir();
    }

    private String normalizeProjectName(String name) {
        return name.toLowerCase().replaceAll("\\s+", "-");
    }
}
