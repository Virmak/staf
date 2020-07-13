package com.sparkit.staf.application.service;

import com.sparkit.staf.application.models.response.compiler.CompileProjectResponse;
import com.sparkit.staf.application.models.response.compiler.CompileTestSuiteResponse;
import com.sparkit.staf.core.ast.StafFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

@Service
public class CompilerService {
    private final TestSuiteService testSuiteService;
    private final ProjectService projectService;

    @Autowired
    public CompilerService(TestSuiteService testSuiteService, ProjectService projectService) {
        this.testSuiteService = testSuiteService;
        this.projectService = projectService;
    }

    public CompileTestSuiteResponse compileTestSuite(String project, String testSuiteName) throws IOException {
        CompileTestSuiteResponse response = new CompileTestSuiteResponse();
        response.setTestSuiteName(testSuiteName);
        response.setFileMap(testSuiteService.compileTestSuiteWithErrors(project, testSuiteName));
        return response;
    }


    public CompileProjectResponse compileProject(String project) throws IOException {
        CompileProjectResponse response = new CompileProjectResponse();
        response.setProjectName(project);
        response.setFileMap(new HashMap<>());
        for (String testSuite : projectService.getProjectTestSuiteNames(project)) {
            response.getFileMap().putAll(compileTestSuite(project, testSuite).getFileMap());
        }
        return response;
    }

    public StafFile compileFile(String filePath) throws IOException {
        return testSuiteService.compileFile(filePath);
    }
}
