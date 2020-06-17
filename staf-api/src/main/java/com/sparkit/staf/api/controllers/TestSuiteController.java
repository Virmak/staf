package com.sparkit.staf.api.controllers;

import com.sparkit.staf.application.models.request.CreateTestSuiteRequest;
import com.sparkit.staf.application.models.response.CreateTestSuiteResponse;
import com.sparkit.staf.application.models.response.DeleteTestSuiteResponse;
import com.sparkit.staf.application.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestSuiteController {
    @Autowired
    private ProjectService projectService;

    @CrossOrigin
    @PostMapping("/testSuite")
    public CreateTestSuiteResponse createTestSuite(@RequestBody CreateTestSuiteRequest request) {
        return projectService.createTestSuite(request);
    }

    @CrossOrigin
    @DeleteMapping("/testSuite/{project}/{testSuite}")
    public DeleteTestSuiteResponse deleteTestSuite(@PathVariable("project") String project, @PathVariable("testSuite") String testSuite) {
        return projectService.deleteTestSuite(project, testSuite);
    }
}
