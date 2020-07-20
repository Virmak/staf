package com.sparkit.staf.api.controllers;

import com.sparkit.staf.application.models.request.CreateTestSuiteRequest;
import com.sparkit.staf.application.models.request.RenameTestSuiteRequest;
import com.sparkit.staf.application.models.response.CreateTestSuiteResponse;
import com.sparkit.staf.application.models.response.DeleteTestSuiteResponse;
import com.sparkit.staf.application.models.response.GetTestSuiteDetailsResponse;
import com.sparkit.staf.application.models.response.RenameTestSuiteResponse;
import com.sparkit.staf.application.service.ProjectService;
import com.sparkit.staf.application.service.TestSuiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@CrossOrigin
@RestController
public class TestSuiteController {
    private final ProjectService projectService;
    private final TestSuiteService testSuiteService;

    @Autowired
    public TestSuiteController(ProjectService projectService, TestSuiteService testSuiteService) {
        this.projectService = projectService;
        this.testSuiteService = testSuiteService;
    }

    @PostMapping("/test-suite")
    public CreateTestSuiteResponse createTestSuite(@RequestBody CreateTestSuiteRequest request) {
        return projectService.createTestSuite(request);
    }

    @PutMapping("/test-suite")
    public RenameTestSuiteResponse renameTestSuite(@RequestBody RenameTestSuiteRequest request) {
        return testSuiteService.renameTestSuite(request);
    }

    @DeleteMapping("/test-suite/{project}/{testSuite}")
    public DeleteTestSuiteResponse deleteTestSuite(@PathVariable("project") String project, @PathVariable("testSuite") String testSuite) {
        return projectService.deleteTestSuite(project, testSuite);
    }

    @GetMapping("/test-suite/{project}/{testSuite}")
    public GetTestSuiteDetailsResponse getTestSuite(@PathVariable("project") String project, @PathVariable("testSuite") String testSuite)
            throws IOException, IllegalAccessException, InstantiationException, InvocationTargetException {
        return testSuiteService.getTestSuiteDetails(project, testSuite);
    }
}
