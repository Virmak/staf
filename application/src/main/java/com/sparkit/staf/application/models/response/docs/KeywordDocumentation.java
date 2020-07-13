package com.sparkit.staf.application.models.response.docs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class KeywordDocumentation {
    private String name;
    private List<KeywordParameter> parameters;
    private String description;

    @Data
    @AllArgsConstructor
    public static class KeywordParameter {
        private String name;
        private String type;
        private boolean optional;
    }
}
