package com.sparkit.staf.api.controllers;

import com.sparkit.staf.application.exception.ProjectNameAlreadyExist;
import com.sparkit.staf.application.models.request.CreateProjectRequest;
import com.sparkit.staf.application.models.response.GetProjectReportsResponse;
import com.sparkit.staf.application.models.response.UpdateProjectConfigResponse;
import com.sparkit.staf.application.service.ProjectService;
import com.sparkit.staf.domain.Directory;
import com.sparkit.staf.domain.ProjectConfig;
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
    private final ProjectService projectService;
    @Value("${testDirectory}")
    String testDir;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/projects")
    public ResponseEntity<Directory> createProject(@RequestBody CreateProjectRequest createProjectRequest) throws IOException {
        try {
            projectService.createProject(createProjectRequest);
        } catch (IOException | ProjectNameAlreadyExist e) {
            Map<String, Object> res = new HashMap<>();
            res.put("error", "Project name already exists");
            e.printStackTrace();
            return ResponseEntity.ok(new Directory());
        }
        return ResponseEntity.ok(projectService.readProjectContent(createProjectRequest.getName()));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/projects/{projectLocation}")
    public Directory getProject(@PathVariable("projectLocation") String projectLocation) {
        File testDirectoryFile = new File(testDir);
        File projectDirectoryFile = new File(testDirectoryFile, projectLocation);
        return projectService.readDirectory(projectDirectoryFile);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/projects")
    public Directory getProjects() {
        File projectsDir = new File(testDir);
        return projectService.readDirectory(projectsDir);
    }

    @CrossOrigin("*")
    @GetMapping("/testReport/{project}/{fileName}")
    public String getTestReport(@PathVariable(name = "project") String project, @PathVariable(name = "fileName") String fileName) throws IOException {
        return projectService.readTestReport(project, fileName);
    }

    @CrossOrigin("*")
    @GetMapping("/projectReports/{project}")
    public GetProjectReportsResponse getProjectReports(@PathVariable(name = "project") String project) throws IOException {
        return projectService.getProjectReports(project);
    }

    @CrossOrigin
    @PutMapping("/projects/config/{projectLocation}")
    public UpdateProjectConfigResponse updateProjectConfig(@PathVariable("projectLocation") String projectLocation,
                                                           @RequestBody ProjectConfig request) {
        return projectService.updateProjectConfig(projectLocation, request);
    }
}
