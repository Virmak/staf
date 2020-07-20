package com.sparkit.staf.core.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sparkit.staf.core.runtime.libs.builtin.selenium.WebDriverOptions;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RunTestRequest {
    private WebDriverOptions webDriverOptions;
    private String project;
    private List<RunTestSuite> testSuites;
}
