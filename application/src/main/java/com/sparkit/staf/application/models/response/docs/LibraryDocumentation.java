package com.sparkit.staf.application.models.response.docs;

import lombok.Data;

import java.util.List;

@Data
public class LibraryDocumentation {
    private String libraryName;
    private List<KeywordDocumentation> keywords;
}
