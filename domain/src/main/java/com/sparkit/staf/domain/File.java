package com.sparkit.staf.domain;

import lombok.Data;

@Data
public class File {
    protected String name;
    protected String fileContent;
    protected FileType type;
}
