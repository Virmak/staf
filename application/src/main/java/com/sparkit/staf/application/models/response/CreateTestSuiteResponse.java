package com.sparkit.staf.application.models.response;

import com.sparkit.staf.domain.Directory;
import lombok.Data;

@Data
public class CreateTestSuiteResponse {
    private String name;
    private String result;
    private String message;
    private Directory content;
}
