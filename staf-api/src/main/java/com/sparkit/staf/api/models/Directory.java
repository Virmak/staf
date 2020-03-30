package com.sparkit.staf.api.models;

import lombok.Data;

import java.util.Map;

@Data
public class Directory extends File {
    protected Map<String, String> content;
}
