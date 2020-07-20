package com.sparkit.staf.application.service;

import com.sparkit.staf.application.models.response.compiler.CompileFileResponse;
import com.sparkit.staf.application.models.response.compiler.CompileProjectResponse;
import com.sparkit.staf.application.models.response.compiler.CompileTestSuiteResponse;
import com.sparkit.staf.core.compiler.TestSuiteCompiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

@Service
public class CompilerService {
    private final TestSuiteCompiler testSuiteCompiler;
    private final ProjectService projectService;

    @Autowired
    public CompilerService(TestSuiteCompiler testSuiteCompiler, ProjectService projectService) {
        this.testSuiteCompiler = testSuiteCompiler;
        this.projectService = projectService;
    }

    public CompileTestSuiteResponse compileTestSuite(String project, String testSuiteName) throws IOException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        CompileTestSuiteResponse response = new CompileTestSuiteResponse();
        response.setTestSuiteName(testSuiteName);
        response.setFileMap(testSuiteCompiler.compileTestSuiteWithErrors(project, testSuiteName));
        return response;
    }


    public CompileProjectResponse compileProject(String project) throws IOException, IllegalAccessException,
            InstantiationException, InvocationTargetException {
        CompileProjectResponse response = new CompileProjectResponse();
        response.setProjectName(project);
        response.setFileMap(new HashMap<>());
        for (String testSuite : projectService.getProjectTestSuiteNames(project)) {
            response.getFileMap().putAll(compileTestSuite(project, testSuite).getFileMap());
        }
        return response;
    }

    public CompileFileResponse compileFile(String filePath) throws IOException, IllegalAccessException,
            InstantiationException, InvocationTargetException {
        CompileFileResponse response = new CompileFileResponse();
        response.setFilePath(filePath);
        response.setFileMap(testSuiteCompiler.compileFile(filePath));
        return response;
    }
}
