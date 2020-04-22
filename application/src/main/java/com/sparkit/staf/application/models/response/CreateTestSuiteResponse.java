package com.sparkit.staf.application.models.response;

import lombok.Data;

import java.util.Map;

@Data
public class CreateTestSuiteResponse {
    private String name;
    private String result;
    private String message;
    private Map<String, Object> content;
}
