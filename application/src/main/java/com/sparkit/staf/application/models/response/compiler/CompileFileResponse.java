package com.sparkit.staf.application.models.response.compiler;

import com.sparkit.staf.core.ast.StafFile;
import lombok.Data;

import java.util.Map;

@Data
public class CompileFileResponse {
    private String filePath;
    private Map<String, StafFile> fileMap;
}
