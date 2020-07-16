package com.sparkit.staf.api.controllers;

import com.sparkit.staf.application.models.response.compiler.CompileFileResponse;
import com.sparkit.staf.application.models.response.compiler.CompileProjectResponse;
import com.sparkit.staf.application.models.response.compiler.CompileTestSuiteResponse;
import com.sparkit.staf.application.service.CompilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@CrossOrigin
@RestController
public class CompilerController {
    private final CompilerService compilerService;

    @Autowired
    public CompilerController(CompilerService compilerService) {
        this.compilerService = compilerService;
    }

    @GetMapping("/compileTestSuite/{projectLocation}/{testSuite}")
    public CompileTestSuiteResponse compileTestSuite(@PathVariable("projectLocation") String project, @PathVariable("testSuite") String testSuite)
            throws IOException, IllegalAccessException, InstantiationException, InvocationTargetException {
        return compilerService.compileTestSuite(project, testSuite);
    }

    @GetMapping("/compileProject/{projectLocation}")
    public CompileProjectResponse compileProject(@PathVariable("projectLocation") String project)
            throws IOException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return compilerService.compileProject(project);
    }

    @GetMapping("/compileFile")
    public CompileFileResponse compileFile(@RequestParam("filePath") String filePath)
            throws IOException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return compilerService.compileFile(filePath);
    }
}
