package com.sparkit.staf.application.models.request;

import lombok.Data;

import java.util.List;

@Data
public class RunTestRequest {
    private String project;
    private List<String> testSuites;
    private String webDriverAddress;
    private int sessionCount;
}
