package com.sparkit.staf.application.service;

import com.sparkit.staf.application.models.request.RenameTestSuiteRequest;
import com.sparkit.staf.application.models.response.GetTestSuiteDetailsResponse;
import com.sparkit.staf.application.models.response.RenameTestSuiteResponse;
import com.sparkit.staf.core.ast.StafFile;
import com.sparkit.staf.core.ast.TestCaseDeclaration;
import com.sparkit.staf.core.compiler.TestSuiteCompiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Service
public class TestSuiteService {
    private final TestSuiteCompiler testSuiteCompiler;

    @Autowired
    public TestSuiteService(TestSuiteCompiler testSuiteCompiler) {
        this.testSuiteCompiler = testSuiteCompiler;
    }

    private static boolean isChild(Path child, String parentText) {
        Path parent = Paths.get(parentText).toAbsolutePath();
        return child.startsWith(parent);
    }

    public GetTestSuiteDetailsResponse getTestSuiteDetails(String project, String testSuiteName) throws IOException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        String testSuiteDirectory = testSuiteCompiler.getTestSuiteMainFile(project, testSuiteName).getParentFile().getAbsolutePath();
        GetTestSuiteDetailsResponse response = new GetTestSuiteDetailsResponse();
        response.setTestSuite(testSuiteName);
        response.setProject(project);
        response.setTestCases(new ArrayList<>());
        for (StafFile ast : testSuiteCompiler.compileTestSuiteWithErrors(project, testSuiteName).values()) {
            response.setSyntaxErrors(ast.getSyntaxErrors());
            if (Objects.nonNull(ast.getTestCaseDeclarationMap()) && isChild(Paths.get(ast.getFilePath()), testSuiteDirectory)) {
                Collection<TestCaseDeclaration> values = ast.getTestCaseDeclarationMap().values();
                for (TestCaseDeclaration testCaseDeclaration : values) {
                    response.getTestCases().add(
                            new GetTestSuiteDetailsResponse.TestCase(testCaseDeclaration.getName(),
                                    testCaseDeclaration.getFilePath(),
                                    testCaseDeclaration.isIgnored(),
                                    !testCaseDeclaration.isDefaultOrder() ? String.valueOf(testCaseDeclaration.getOrder()) : "N/A"));
                }
            }
        }
        return response;
    }

    public RenameTestSuiteResponse renameTestSuite(RenameTestSuiteRequest renameRequest) {
        RenameTestSuiteResponse response = new RenameTestSuiteResponse();
        String normalizedProjectName = ProjectService.normalizeProjectName(renameRequest.getProjectName());
        File testSuiteDirectory = testSuiteCompiler.getTestSuiteDirectory(normalizedProjectName,
                renameRequest.getOldTestSuiteName());
        boolean renameToResult = testSuiteDirectory.renameTo(testSuiteCompiler.getTestSuiteDirectory(normalizedProjectName, renameRequest.getNewTesSuiteName()));
        if (renameToResult) {
            response.setResult("ok");
        } else {
            response.setResult("error");
        }
        return response;
    }
}
