package com.sparkit.staf.api.service;

import com.sparkit.staf.api.application.IProjectBuilder;
import com.sparkit.staf.api.application.exception.ProjectNameAlreadyExist;
import com.sparkit.staf.api.exception.TestDirectoryNotFound;
import com.sparkit.staf.api.models.ProjectConfig;
import com.sparkit.staf.api.models.request.CreateProjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private IProjectBuilder projectBuilder;

    @Value("${testDirectory}")
    private String projectsDirPath;

    public List<String> readProjects() throws TestDirectoryNotFound {
        File currentDir = new File(System.getProperty("user.dir"));
        File projectsDir = new File(currentDir, projectsDirPath);
        List<String> projects = new ArrayList<>();
        File[] files = projectsDir.listFiles();
        if (files != null) {
            Arrays.stream(files).forEach(f -> projects.add(f.getName()));
        } else {
            throw new TestDirectoryNotFound(projectsDirPath);
        }
        return projects;
    }

    public ProjectConfig createProject(CreateProjectRequest createProjectRequest) throws IOException, ProjectNameAlreadyExist {
        return projectBuilder.build(createProjectRequest);
    }

    public static String normalizeProjectName(String name) {
        return name.toLowerCase().replaceAll("\\s+", "-");
    }
}
