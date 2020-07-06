package com.sparkit.staf.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Directory extends File {
    private List<File> content;
}
