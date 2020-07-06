package com.sparkit.staf.core.ast;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenPosition {
    private int line;
    private int charPositionInLine;
    private int start;
    private int stop;
    private String filePath;
}
