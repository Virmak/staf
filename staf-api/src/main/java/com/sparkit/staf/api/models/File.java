package com.sparkit.staf.api.models;

import lombok.Data;

@Data
public class File {
    protected String name;
    protected String fileContent;
    protected FileType type;
}
