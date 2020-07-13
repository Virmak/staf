package com.sparkit.staf.api.controllers;

import com.sparkit.staf.application.exception.ProjectNameAlreadyExist;
import com.sparkit.staf.application.models.request.CreateProjectRequest;
import com.sparkit.staf.application.models.response.project.GetProjectReportsResponse;
import com.sparkit.staf.application.models.response.project.UpdateProjectConfigResponse;
import com.sparkit.staf.application.service.ProjectService;
import com.sparkit.staf.domain.Directory;
import com.sparkit.staf.domain.ProjectConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zeroturnaround.zip.ZipUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

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
            e.printStackTrace();
            return ResponseEntity.ok(new Directory());
        }
        return ResponseEntity.ok(projectService.readProjectContent(createProjectRequest.getLocation()));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/projects/{projectLocation}")
    public Directory getProject(@PathVariable("projectLocation") String projectLocation) {
        return projectService.readDirectory(projectService.getProjectDirectoryFile(projectLocation));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/projects")
    public Directory getAllProjects() {
        File projectsDir = new File(testDir);
        return projectService.readDirectory(projectsDir);
    }

    @CrossOrigin("*")
    @GetMapping("/testReport/{reportFilePath}")
    public String getTestReport(@PathVariable(name = "reportFilePath") String reportFilePath) throws IOException {
        return projectService.readTestReport(reportFilePath.replace("<sep>", "/"));
    }

    @CrossOrigin("*")
    @GetMapping("/projectReports/{projectLocation}")
    public GetProjectReportsResponse getProjectReports(@PathVariable(name = "projectLocation") String projectLocation) throws IOException {
        return projectService.getProjectReports(projectLocation);
    }

    @CrossOrigin
    @PutMapping("/projects/config/{projectLocation}")
    public UpdateProjectConfigResponse updateProjectConfig(@PathVariable("projectLocation") String projectLocation,
                                                           @RequestBody ProjectConfig request) {
        return projectService.updateProjectConfig(projectLocation, request);
    }

    @CrossOrigin
    @GetMapping("/projects/reportsDir/{projectLocation}")
    public Directory getProjectReportsDirectory(@PathVariable("projectLocation") String projectLocation) throws IOException {
        ProjectConfig config = projectService.getProjectConfig(projectLocation);
        File projectDirectoryFile = projectService.getProjectDirectoryFile(projectLocation);
        return projectService.readDirectory(new File(projectDirectoryFile, config.getReportsDir()));
    }

    @CrossOrigin
    @GetMapping("/projects/download/{projectLocation}")
    public byte[] zipFiles(HttpServletResponse response, @PathVariable("projectLocation") String projectLocation) throws IOException {
        //setting headers
        response.setContentType("application/zip");
        response.setStatus(HttpServletResponse.SC_OK);
        response.addHeader("Content-Disposition", "attachment; filename=\"" + projectLocation + ".zip\"");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ZipUtil.pack(projectService.getProjectDirectoryFile(projectLocation), byteArrayOutputStream, name -> projectLocation + "/" + name);
        return byteArrayOutputStream.toByteArray();
    }


}
