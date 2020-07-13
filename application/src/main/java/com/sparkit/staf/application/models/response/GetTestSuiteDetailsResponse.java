package com.sparkit.staf.application.models.response;

import com.sparkit.staf.core.parser.SyntaxError;
import lombok.Data;

import java.util.List;

@Data
public class GetTestSuiteDetailsResponse {
    private String testSuite;
    private String project;
    private List<TestCase> testCases;
    private List<SyntaxError> syntaxErrors;
    @Data
    public static class TestCase {
        private String name;
        private String path;
        private boolean ignored;
        private String order;
        public TestCase(String testCaseName, String declarationPath, boolean ignored, String order) {
            this.name = testCaseName;
            this.path = declarationPath;
            this.ignored = ignored;
            this.order = order;
        }

    }
}
