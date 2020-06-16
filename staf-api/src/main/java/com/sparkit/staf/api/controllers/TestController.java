package com.sparkit.staf.api.controllers;

import com.sparkit.staf.application.exception.ProjectNotFoundException;
import com.sparkit.staf.application.exception.TestDirectoryNotFound;
import com.sparkit.staf.application.models.request.RunTestRequest;
import com.sparkit.staf.application.service.ProjectService;
import com.sparkit.staf.core.StafTestFacade;
import com.sparkit.staf.core.runtime.interpreter.StafScriptInterpreter;
import com.sparkit.staf.core.runtime.loader.exceptions.ConfigFileNotFoundException;
import com.sparkit.staf.core.runtime.reports.TestSuiteReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class TestController {
    @Value("${testDirectory}")
    String testDir;
    @Autowired
    private StafTestFacade testFacade;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private StafScriptInterpreter interpreter;

    @CrossOrigin("*")
    @PostMapping("/runTest")
    public List<TestSuiteReport> runTest(@RequestBody RunTestRequest runTestRequest)
            throws ConfigFileNotFoundException, ProjectNotFoundException, TestDirectoryNotFound {
        String project = runTestRequest.getProject().replaceAll("\\s+", "-").toLowerCase(); // normalize project name
        for (String projectName : projectService.readProjects()) {
            if (project.equals(projectName)) {
                return testFacade.runProject(testDir, projectName, testDir + "/" + project + "/" + "config.json",
                        runTestRequest.getTestSuites(), runTestRequest.getWebDriverAddress());
            }
        }
        throw new ProjectNotFoundException();
    }

    @CrossOrigin("*")
    @PostMapping("/terminateTest")
    public String terminateTest() {
        interpreter.terminateTestExecution();
        return "{\"result\": \"Test terminated\"}";
    }
}
