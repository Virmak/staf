package com.sparkit.staf.api.models.request;

import lombok.Data;

import java.util.List;

@Data
public class RunTestRequest {
    private String project;
    private List<String> testSuites;
}
