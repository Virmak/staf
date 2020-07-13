package com.sparkit.staf.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class File {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String fileContent;
    protected String name;
    protected String path;
    protected FileType type;
}
