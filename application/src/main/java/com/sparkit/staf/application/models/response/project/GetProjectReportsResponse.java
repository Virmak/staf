package com.sparkit.staf.application.models.response.project;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class GetProjectReportsResponse {
    private String projectName;
    private List<ReportFile> reportsFileNameList;

    @Data
    @AllArgsConstructor
    public static class ReportFile {
        private String fileName;
        private String path;
    }
}
