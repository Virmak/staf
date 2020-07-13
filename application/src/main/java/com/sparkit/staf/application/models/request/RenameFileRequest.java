package com.sparkit.staf.application.models.request;

import lombok.Data;

@Data
public class RenameFileRequest {
    private String filePath;
    private String newName;
}
