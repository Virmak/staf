package com.sparkit.staf.application.models.request;

import lombok.Data;

@Data
public class RenameTestSuiteRequest {
    private String projectName;
    private String oldTestSuiteName;
    private String newTesSuiteName;
}
