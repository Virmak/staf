package com.sparkit.staf.api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    @Value("${testDirectory}")
    private String projectsDirPath;

    public List<String> getProjects() {
        String testDir = System.getProperty("user.dir") + "/" + projectsDirPath;
        File projectsDir = new File(testDir);
        List<String> projects = new ArrayList<>();
        for (File f : projectsDir.listFiles()) {
            projects.add(f.getName());
        }
        return projects;
    }
}
