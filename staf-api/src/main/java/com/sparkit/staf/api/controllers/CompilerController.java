package com.sparkit.staf.api.controllers;

import com.sparkit.staf.application.models.response.compiler.CompileFileResponse;
import com.sparkit.staf.application.models.response.compiler.CompileProjectResponse;
import com.sparkit.staf.application.models.response.compiler.CompileTestSuiteResponse;
import com.sparkit.staf.application.service.CompilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

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
            throws IOException, IllegalAccessException, InstantiationException, InvocationTargetException {
        return compilerService.compileTestSuite(project, testSuite);
    }

    @CrossOrigin
    @GetMapping("/compileProject/{projectLocation}")
    public CompileProjectResponse compileProject(@PathVariable("projectLocation") String project)
            throws IOException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return compilerService.compileProject(project);
    }

    @CrossOrigin
    @GetMapping("/compileFile")
    public CompileFileResponse compileFile(@RequestParam("filePath") String filePath)
            throws IOException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return compilerService.compileFile(filePath);
    }
}
