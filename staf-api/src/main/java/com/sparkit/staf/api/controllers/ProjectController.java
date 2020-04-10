package com.sparkit.staf.api.controllers;

import com.sparkit.staf.api.application.exception.ProjectNameAlreadyExist;
import com.sparkit.staf.api.models.ProjectConfig;
import com.sparkit.staf.api.models.request.CreateProjectRequest;
import com.sparkit.staf.api.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ProjectController {
    @Value("${testDirectory}")
    String testDir;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ModelMapper mapper;

    @CrossOrigin(origins = "*")
    @PostMapping("/projects")
    public ResponseEntity<Map<String, Object>> createProject(@RequestBody CreateProjectRequest createProjectRequest) throws IOException {
        try {
            ProjectConfig config = projectService.createProject(createProjectRequest);
        } catch (IOException | ProjectNameAlreadyExist e) {
            Map<String, Object> res = new HashMap<>();
            res.put("error", "Project name already exists");
            return ResponseEntity.ok(res);
        }
        File projectDir = new File(testDir, ProjectService.normalizeProjectName(createProjectRequest.getName()));
        String currentDir = System.getProperty("user.dir");
        String absoluteTestDir = currentDir + "/" + testDir;
        return ResponseEntity.ok(projectService.listDirectory(projectDir, absoluteTestDir));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/projects")
    public Map<String, Object> getProjects() throws IOException {
        String currentDir = System.getProperty("user.dir");
        String absoluteTestDir = currentDir + "/" + testDir;
        File projectsDir = new File(testDir);
        return projectService.listDirectory(projectsDir, absoluteTestDir);
    }

}