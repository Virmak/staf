package com.sparkit.staf.api.controllers;

import com.sparkit.staf.application.models.request.CreateTestSuiteRequest;
import com.sparkit.staf.application.models.request.RenameTestSuiteRequest;
import com.sparkit.staf.application.models.response.CreateTestSuiteResponse;
import com.sparkit.staf.application.models.response.DeleteTestSuiteResponse;
import com.sparkit.staf.application.models.response.GetTestSuiteDetailsResponse;
import com.sparkit.staf.application.models.response.RenameTestSuiteResponse;
import com.sparkit.staf.application.service.ProjectService;
import com.sparkit.staf.application.service.TestSuiteService;
import com.sparkit.staf.core.parser.SyntaxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class TestSuiteController {
    private final ProjectService projectService;
    private final TestSuiteService testSuiteService;

    @Autowired
    public TestSuiteController(ProjectService projectService, TestSuiteService testSuiteService) {
        this.projectService = projectService;
        this.testSuiteService = testSuiteService;
    }

    @CrossOrigin
    @PostMapping("/testSuite")
    public CreateTestSuiteResponse createTestSuite(@RequestBody CreateTestSuiteRequest request) {
        return projectService.createTestSuite(request);
    }

    @CrossOrigin
    @PutMapping("/testSuite")
    public RenameTestSuiteResponse renameTestSuite(@RequestBody RenameTestSuiteRequest request) {
        return testSuiteService.renameTestSuite(request);
    }

    @CrossOrigin
    @DeleteMapping("/testSuite/{project}/{testSuite}")
    public DeleteTestSuiteResponse deleteTestSuite(@PathVariable("project") String project, @PathVariable("testSuite") String testSuite) {
        return projectService.deleteTestSuite(project, testSuite);
    }

    @CrossOrigin
    @GetMapping("/testSuite/{project}/{testSuite}")
    public GetTestSuiteDetailsResponse getTestSuite(@PathVariable("project") String project, @PathVariable("testSuite") String testSuite)
            throws IOException, SyntaxErrorException {
        return testSuiteService.getTestSuiteDetails(project, testSuite);
    }
}
