package com.sparkit.staf.application.models.request;

import com.sparkit.staf.domain.FileType;
import lombok.Data;

@Data
public class CreateFileRequest {
    private FileType type;
    private String path;
}
