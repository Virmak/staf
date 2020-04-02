package com.sparkit.staf.api.controllers;

import com.sparkit.staf.api.exception.ProjectNotFoundException;
import com.sparkit.staf.api.exception.TestDirectoryNotFound;
import com.sparkit.staf.api.models.request.RunTestRequest;
import com.sparkit.staf.api.service.ProjectService;
import com.sparkit.staf.core.StafTestFacade;
import com.sparkit.staf.core.runtime.loader.exceptions.ConfigFileNotFoundException;
import com.sparkit.staf.core.runtime.reports.TestCaseReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    @Autowired
    private StafTestFacade testFacade;
    @Autowired
    private ProjectService projectService;
    @Value("${testDirectory}")
    String testDir;

    @CrossOrigin("*")
    @PostMapping("/runTest")
    public Map<String, List<TestCaseReport>> runTest(@RequestBody RunTestRequest runTestRequest)
            throws ConfigFileNotFoundException, ProjectNotFoundException, TestDirectoryNotFound {
        String project = runTestRequest.getProject().replaceAll("\\s+", "-").toLowerCase(); // normalize project name
        for (String projectName : projectService.readProjects()) {
            if (project.equals(projectName)) {
                return testFacade.runTests(projectName,testDir + "/" + project + "/" + "config.json", Arrays.asList(runTestRequest.getTestSuites()));
            }
        }
        throw new ProjectNotFoundException();
    }
}
