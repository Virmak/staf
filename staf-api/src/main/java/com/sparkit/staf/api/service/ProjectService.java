package com.sparkit.staf.api.service;

import com.sparkit.staf.api.exception.TestDirectoryNotFound;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProjectService {
    @Value("${testDirectory}")
    private String projectsDirPath;

    public List<String> getProjects() throws TestDirectoryNotFound {
        File currentDir = new File(System.getProperty("user.dir"));
        File projectsDir = new File(currentDir, projectsDirPath);
        List<String> projects = new ArrayList<>();
        File [] files = projectsDir.listFiles();
        if (files != null) {
            Arrays.stream(files).forEach(f -> projects.add(f.getName()));
        } else {
            throw new TestDirectoryNotFound(projectsDirPath);
        }
        return projects;
    }
}
