package com.sparkit.staf.application;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sparkit.staf.application.exception.ProjectNameAlreadyExist;
import com.sparkit.staf.application.models.request.CreateProjectRequest;
import com.sparkit.staf.application.models.request.CreateTestSuiteRequest;
import com.sparkit.staf.application.models.request.TestSuiteType;
import com.sparkit.staf.core.runtime.config.JsonStafProjectConfig;
import com.sparkit.staf.domain.ProjectConfig;
import com.sparkit.staf.domain.ProjectType;
import com.sparkit.staf.domain.TestSuite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Component
public class ProjectBuilder implements IProjectBuilder {
    private final ObjectMapper mapper;

    @Value("${testDirectory}")
    private String testDir;

    @Value("classpath:config_template.json")
    private Resource templateProjectConfig;

    @Autowired
    public ProjectBuilder(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ProjectConfig buildProject(CreateProjectRequest createProjectRequest) throws IOException, ProjectNameAlreadyExist {
        ProjectConfig config = getProjectConfigTemplate();
        config.setProject(createProjectRequest.getName());
        config.setDescription(createProjectRequest.getDescription());
        config.setLogDir(createProjectRequest.getLogDir());
        config.setReportsDir(createProjectRequest.getReportsDirPath());
        config.setType(createProjectRequest.getType());
        config.setLocation(createProjectRequest.getLocation());
        config.setTestSuites(new ArrayList<>());
        File projectDir = new File(testDir, normalizeProjectName(createProjectRequest.getName()));
        if (projectDir.exists()) {
            throw new ProjectNameAlreadyExist();
        } else {
            projectDir.mkdir();
            writeConfigFile(config, projectDir);
            if (createProjectRequest.getType() == ProjectType.UITest) {
                createUITestSuite("UI test suite", config, projectDir);
            } else if (createProjectRequest.getType() == ProjectType.APITest) {
                createAPITestSuite("API test suite", config, projectDir);
            }
        }
        return config;
    }

    @Override
    public TestSuite buildTestSuite(CreateTestSuiteRequest createTestSuiteRequest) throws IOException {
        TestSuite testSuite = new TestSuite();
        File projectDir = new File(testDir + "/" + normalizeProjectName(createTestSuiteRequest.getProjectName()));
        if (createTestSuiteRequest.getType() == TestSuiteType.UITest) {
            createUITestSuite(createTestSuiteRequest.getName(), null, projectDir);
        } else if (createTestSuiteRequest.getType() == TestSuiteType.APITest) {
            createAPITestSuite(createTestSuiteRequest.getName(), null, projectDir);
        }
        testSuite.setName(createTestSuiteRequest.getName());
        testSuite.setRootPath(projectDir.getPath() + "/" + createTestSuiteRequest.getName());
        return testSuite;
    }

    public void writeConfigFile(ProjectConfig config, File projectDir) throws IOException {
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File(projectDir, JsonStafProjectConfig.DEFAULT_PROJECT_CONFIG_FILE), config);
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
        if (config != null) {
            config.getTestSuites().add(testSuiteName);
        }
    }

    private void createAPITestSuite(String testSuiteName, ProjectConfig config, File projectDir) throws IOException { // Create structure for API Testing project
        File testSuiteDir = new File(projectDir, testSuiteName);
        testSuiteDir.mkdir();
        File requestsDir = new File(testSuiteDir, "requests");
        requestsDir.mkdir();
        File mainFile = new File(testSuiteDir, "main.staf");
        mainFile.createNewFile();
        if (config != null) {
            config.getTestSuites().add(testSuiteName);
        }
    }

    private ProjectConfig getProjectConfigTemplate() throws IOException {
        return mapper.readValue(templateProjectConfig.getInputStream(), ProjectConfig.class);
    }

    private String normalizeProjectName(String name) {
        return name.toLowerCase().replaceAll("\\s+", "-");
    }
}
