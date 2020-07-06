package com.sparkit.staf.core.runtime.interpreter;

import com.sparkit.staf.core.ast.TokenPosition;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SemanticError {
    private TokenPosition position;
    private String message;
}
