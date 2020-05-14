package com.sparkit.staf.application.models.request;

import lombok.Data;

@Data
public class CreateTestSuiteRequest {
    private String name;
    private TestSuiteType type;
    private String projectName;
}
