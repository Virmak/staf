package com.sparkit.staf.api.controllers;

import com.sparkit.staf.application.exception.ProjectNotFoundException;
import com.sparkit.staf.application.exception.TestDirectoryNotFound;
import com.sparkit.staf.application.models.response.GenericResponse;
import com.sparkit.staf.application.service.ProjectService;
import com.sparkit.staf.core.StafTestFacade;
import com.sparkit.staf.core.models.RunTestRequest;
import com.sparkit.staf.core.runtime.config.JsonStafProjectConfig;
import com.sparkit.staf.core.runtime.interpreter.StafScriptInterpreter;
import com.sparkit.staf.core.runtime.reports.TestSuiteReport;
import com.sparkit.staf.core.utils.SharedConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@CrossOrigin
@RestController
public class TestController {
    private final StafTestFacade testFacade;
    private final ProjectService projectService;
    private final StafScriptInterpreter stafScriptInterpreter;
    @Value("${testDirectory}")
    String testDir;

    @Autowired
    public TestController(StafTestFacade testFacade, ProjectService projectService, StafScriptInterpreter stafScriptInterpreter) {
        this.testFacade = testFacade;
        this.projectService = projectService;
        this.stafScriptInterpreter = stafScriptInterpreter;
    }

    @PostMapping("/test/run")
    public List<TestSuiteReport> runTest(@RequestBody RunTestRequest runTestRequest) throws ProjectNotFoundException,
            TestDirectoryNotFound, IOException {
        String project = runTestRequest.getProject().replaceAll("\\s+", "-").toLowerCase(); // normalize project name
        for (String projectName : projectService.getProjectsList()) {
            if (project.equals(projectName)) {
                return testFacade.runProject(testDir, projectName, testDir + "/" + project + "/" + JsonStafProjectConfig.DEFAULT_PROJECT_CONFIG_FILE, runTestRequest);
            }
        }
        throw new ProjectNotFoundException();
    }

    @PostMapping("/test/terminate")
    public GenericResponse terminateTest() {
        stafScriptInterpreter.terminateTestExecution();
        return new GenericResponse(SharedConstants.OK_RESULT_STRING);
    }

    @GetMapping("/host-address")
    public GenericResponse resolveHost() throws UnknownHostException {
        return new GenericResponse(InetAddress.getLocalHost().getHostAddress());
    }
}
