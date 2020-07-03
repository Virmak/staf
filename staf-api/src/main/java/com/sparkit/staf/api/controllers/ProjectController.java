package com.sparkit.staf.api.controllers;

import com.sparkit.staf.application.exception.ProjectNameAlreadyExist;
import com.sparkit.staf.application.models.request.CreateProjectRequest;
import com.sparkit.staf.application.models.response.GetProjectReportsResponse;
import com.sparkit.staf.application.models.response.UpdateProjectConfigResponse;
import com.sparkit.staf.application.service.ProjectService;
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
    public ResponseEntity<Map<String, Object>> createProject(@RequestBody CreateProjectRequest createProjectRequest) throws IOException {
        try {
            projectService.createProject(createProjectRequest);
        } catch (IOException | ProjectNameAlreadyExist e) {
            Map<String, Object> res = new HashMap<>();
            res.put("error", "Project name already exists");
            e.printStackTrace();
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.ok(projectService.readProjectContent(createProjectRequest.getName()));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/projects/{projectName}")
    public Map<String, Object> getProject(@PathVariable("projectName") String projectName) {
        String currentDir = System.getProperty("user.dir");
        String absoluteTestDir = currentDir + "/" + testDir;
        File testDirectoryFile = new File(testDir);
        File projectDirectoryFile = new File(testDirectoryFile, ProjectService.normalizeProjectName(projectName));
        return projectService.listDirectory(projectDirectoryFile, absoluteTestDir);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/projects")
    public Map<String, Object> getProjects() {
        String currentDir = System.getProperty("user.dir");
        String absoluteTestDir = currentDir + "/" + testDir;
        File projectsDir = new File(testDir);
        return projectService.listDirectory(projectsDir, absoluteTestDir);
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
