package com.sparkit.staf.application.models.response.project;

import lombok.Data;

import java.util.List;

@Data
public class GetProjectReportsResponse {
    private String projectName;
    private List<String> reportsFileNameList;
}
