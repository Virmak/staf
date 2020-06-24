package com.sparkit.staf.api.controllers;

import com.sparkit.staf.application.exception.ProjectNotFoundException;
import com.sparkit.staf.application.exception.TestDirectoryNotFound;
import com.sparkit.staf.application.models.request.RunTestRequest;
import com.sparkit.staf.application.service.ProjectService;
import com.sparkit.staf.core.StafTestFacade;
import com.sparkit.staf.core.parser.SyntaxErrorException;
import com.sparkit.staf.core.runtime.interpreter.StafScriptInterpreter;
import com.sparkit.staf.core.runtime.loader.exceptions.ConfigFileNotFoundException;
import com.sparkit.staf.core.runtime.loader.exceptions.TestSuiteMainScriptNotFoundException;
import com.sparkit.staf.core.runtime.reports.TestSuiteReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
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
    public List<TestSuiteReport> runTest(@RequestBody RunTestRequest runTestRequest) throws ConfigFileNotFoundException,
            ProjectNotFoundException, TestDirectoryNotFound, SyntaxErrorException, TestSuiteMainScriptNotFoundException {
        if (runTestRequest.getTestSuites().size() > 1) {
            logger.error("Run 1 test suite at a given time");
            return null;
        }
        String project = runTestRequest.getProject().replaceAll("\\s+", "-").toLowerCase(); // normalize project name
        for (String projectName : projectService.getProjectsList()) {
            if (project.equals(projectName)) {
                return testFacade.runProject(testDir, projectName, testDir + "/" + project + "/" + "config.json",
                        runTestRequest.getTestSuites().get(0), runTestRequest.getWebDriverOptions(), runTestRequest.getWebDriverOptions().getSessionCount());
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
