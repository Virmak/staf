package com.sparkit.staf.application.service;

import com.sparkit.staf.application.models.response.CompileTestSuiteResponse;
import com.sparkit.staf.core.runtime.loader.IStafCompiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CompilerService {
    private final IStafCompiler stafCompiler;
    private final TestSuiteService testSuiteService;

    @Autowired
    public CompilerService(IStafCompiler stafCompiler, TestSuiteService testSuiteService) {
        this.stafCompiler = stafCompiler;
        this.testSuiteService = testSuiteService;
    }

    public CompileTestSuiteResponse compileTestSuite(String project, String testSuiteName) throws IOException {
        CompileTestSuiteResponse response = new CompileTestSuiteResponse();
        response.setTestSuiteName(testSuiteName);
        response.setFileMap(testSuiteService.compileWithErrors(project, testSuiteName));
        return response;
    }


}
