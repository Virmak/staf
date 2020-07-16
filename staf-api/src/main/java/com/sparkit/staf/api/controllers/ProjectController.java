package com.sparkit.staf.api.controllers;

import com.sparkit.staf.application.exception.ProjectNameAlreadyExist;
import com.sparkit.staf.application.models.request.CreateProjectRequest;
import com.sparkit.staf.application.models.response.project.GetProjectReportsResponse;
import com.sparkit.staf.application.models.response.project.UpdateProjectConfigResponse;
import com.sparkit.staf.application.service.ProjectService;
import com.sparkit.staf.core.utils.SharedConstants;
import com.sparkit.staf.domain.Directory;
import com.sparkit.staf.domain.ProjectConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@CrossOrigin("*")
@RestController
public class ProjectController {
    private final ProjectService projectService;
    @Value(SharedConstants.TEST_DIRECTORY_PROPERTY_VALUE)
    private String testDirectory;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/projects")
    public ResponseEntity<Directory> createProject(@RequestBody CreateProjectRequest createProjectRequest) {
        try {
            projectService.createProject(createProjectRequest);
        } catch (IOException | ProjectNameAlreadyExist e) {
            e.printStackTrace();
            return ResponseEntity.ok(new Directory());
        }
        return ResponseEntity.ok(projectService.readProjectContent(createProjectRequest.getLocation()));
    }

    @GetMapping("/projects/{projectLocation}")
    public Directory getProject(@PathVariable("projectLocation") String projectLocation) {
        return projectService.readDirectory(projectService.getProjectDirectoryFile(projectLocation));
    }

    @GetMapping("/projects")
    public Directory getAllProjects() {
        File projectsDir = new File(testDirectory);
        return projectService.readDirectory(projectsDir);
    }

    @GetMapping("/testReport/{reportFilePath}")
    public String getTestReport(@PathVariable(name = "reportFilePath") String reportFilePath) throws IOException {
        return projectService.readTestReport(reportFilePath.replace("<sep>", "/"));
    }

    @GetMapping("/projectReports/{projectLocation}")
    public GetProjectReportsResponse getProjectReportFiles(@PathVariable(name = "projectLocation") String projectLocation) throws IOException {
        return projectService.getProjectReportFiles(projectLocation);
    }

    @PutMapping("/projects/config/{projectLocation}")
    public UpdateProjectConfigResponse updateProjectConfig(@PathVariable("projectLocation") String projectLocation,
                                                           @RequestBody ProjectConfig request) {
        return projectService.updateProjectConfig(projectLocation, request);
    }

    @GetMapping("/projects/reportsDir/{projectLocation}")
    public Directory getProjectReportsDirectory(@PathVariable("projectLocation") String projectLocation) throws IOException {
        ProjectConfig config = projectService.getProjectConfig(projectLocation);
        File projectDirectoryFile = projectService.getProjectDirectoryFile(projectLocation);
        return projectService.readDirectory(new File(projectDirectoryFile, config.getReportsDir()));
    }

    @GetMapping("/projects/download/{projectLocation}")
    public byte[] zipProject(HttpServletResponse response, @PathVariable("projectLocation") String projectLocation) {
        response.setContentType("application/zip");
        response.setStatus(HttpServletResponse.SC_OK);
        response.addHeader("Content-Disposition", "attachment; filename=\"" + projectLocation + ".zip\"");
        return projectService.compressProject(projectLocation);
    }

    @PostMapping("/projects/upload")
    public String uploadProject(@RequestParam("file") MultipartFile file) throws IOException {
        projectService.unpackProject(file.getInputStream());
        return "{\"result\": \"ok\"}";
    }
}
