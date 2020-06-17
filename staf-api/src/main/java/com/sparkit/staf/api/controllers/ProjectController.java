package com.sparkit.staf.api.controllers;

import com.sparkit.staf.application.exception.ProjectNameAlreadyExist;
import com.sparkit.staf.application.models.request.CreateProjectRequest;
import com.sparkit.staf.application.models.request.CreateTestSuiteRequest;
import com.sparkit.staf.application.models.response.CreateTestSuiteResponse;
import com.sparkit.staf.application.models.response.GetProjectReportsResponse;
import com.sparkit.staf.application.service.ProjectService;
import com.sparkit.staf.domain.ProjectConfig;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    @CrossOrigin
    @PostMapping("/testSuite")
    public CreateTestSuiteResponse createTestSuite(@RequestBody CreateTestSuiteRequest request) {
        return projectService.createTestSuite(request);
    }

    @CrossOrigin("*")
    @GetMapping("/testReport/{project}/{fileName}")
    public String getTestReport(@PathVariable(name = "project") String project, @PathVariable(name = "fileName") String fileName) throws IOException {
        // refactor to project service
        String filePath = testDir + "/" + ProjectService.normalizeProjectName(project) + "/results/" + fileName;
        return  new String(Files.readAllBytes(Paths.get(filePath)));
    }

    @CrossOrigin("*")
    @GetMapping("/projectReports/{project}")
    public GetProjectReportsResponse getProjectReports(@PathVariable(name = "project") String project) {
        return projectService.getProjectReports(project);
    }
}
