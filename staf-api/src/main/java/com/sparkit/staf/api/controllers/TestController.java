package com.sparkit.staf.api.controllers;

import com.sparkit.staf.core.StafTestFacade;
import com.sparkit.staf.core.runtime.loader.exceptions.ConfigFileNotFoundException;
import com.sparkit.staf.core.runtime.reports.TestCaseReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    @Autowired StafTestFacade testFacade;

    @PostMapping("/runTest")
    public Map<String, List<TestCaseReport>> runTest() throws ConfigFileNotFoundException {
        return testFacade.runTests("config.json");
    }
}
