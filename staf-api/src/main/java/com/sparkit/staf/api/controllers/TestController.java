package com.sparkit.staf.api.controllers;

import com.sparkit.staf.application.exception.ProjectNotFoundException;
import com.sparkit.staf.application.exception.TestDirectoryNotFound;
import com.sparkit.staf.application.models.request.RunTestRequest;
import com.sparkit.staf.application.service.ProjectService;
import com.sparkit.staf.core.StafTestFacade;
import com.sparkit.staf.core.runtime.loader.exceptions.ConfigFileNotFoundException;
import com.sparkit.staf.core.runtime.reports.TestSuiteReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Value("${testDirectory}")
    String testDir;
    @Autowired
    private StafTestFacade testFacade;
    @Autowired
    private ProjectService projectService;

    @CrossOrigin("*")
    @PostMapping("/runTest")
    public List<TestSuiteReport> runTest(@RequestBody RunTestRequest runTestRequest)
            throws ConfigFileNotFoundException, ProjectNotFoundException, TestDirectoryNotFound {
        String project = runTestRequest.getProject().replaceAll("\\s+", "-").toLowerCase(); // normalize project name
        for (String projectName : projectService.readProjects()) {
            if (project.equals(projectName)) {
                return testFacade.runProject(testDir, projectName, testDir + "/" + project + "/" + "config.json", runTestRequest.getTestSuites());
            }
        }
        throw new ProjectNotFoundException();
    }
}
