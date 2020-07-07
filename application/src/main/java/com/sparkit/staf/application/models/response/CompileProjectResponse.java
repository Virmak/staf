package com.sparkit.staf.application.models.response;

import com.sparkit.staf.core.ast.StafFile;
import lombok.Data;

import java.util.Map;

@Data
public class CompileProjectResponse {
    private String projectName;
    private Map<String, StafFile> fileMap;
}
