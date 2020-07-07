package com.sparkit.staf.api.controllers;

import com.sparkit.staf.application.models.response.CompileProjectResponse;
import com.sparkit.staf.application.models.response.CompileTestSuiteResponse;
import com.sparkit.staf.application.service.CompilerService;
import com.sparkit.staf.core.ast.StafFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class CompilerController {
    private final CompilerService compilerService;

    @Autowired
    public CompilerController(CompilerService compilerService) {
        this.compilerService = compilerService;
    }

    @CrossOrigin
    @GetMapping("/compileTestSuite/{projectLocation}/{testSuite}")
    public CompileTestSuiteResponse compileTestSuite(@PathVariable("projectLocation") String project, @PathVariable("testSuite") String testSuite)
            throws IOException {
        return compilerService.compileTestSuite(project, testSuite);
    }

    @CrossOrigin
    @GetMapping("/compileProject/{projectLocation}")
    public CompileProjectResponse compileProject(@PathVariable("projectLocation") String project)
            throws IOException {
        return compilerService.compileProject(project);
    }

    @CrossOrigin
    @GetMapping("/compileFile/{filePath}")
    public StafFile compileFile(@PathVariable("filePath") String filePath)
            throws IOException {
        return compilerService.compileFile(filePath);
    }
}
