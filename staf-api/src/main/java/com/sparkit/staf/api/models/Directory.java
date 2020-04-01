package com.sparkit.staf.api.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
public class Directory extends File {
    protected Map<String, String> content;
}
