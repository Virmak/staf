package com.sparkit.staf.application.models.response;

import lombok.Data;

import java.util.List;

@Data
public class GetTestSuiteDetailsResponse {
    private String testSuite;
    private String project;
    private List<TestCase> testCases;

    @Data
    public class TestCase {
        private String name;
        private String path;
        private boolean ignored;
        private int order;
        public TestCase(String testCaseName, String declarationPath, boolean ignored, int order) {
            this.name = testCaseName;
            this.path = declarationPath;
            this.ignored = ignored;
            this.order = order;
        }

    }
}
