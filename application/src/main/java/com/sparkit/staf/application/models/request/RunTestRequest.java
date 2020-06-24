package com.sparkit.staf.application.models.request;

import com.sparkit.staf.core.runtime.libs.builtin.selenium.WebDriverOptions;
import lombok.Data;

import java.util.List;

@Data
public class RunTestRequest {
    private String project;
    private List<String> testSuites;
    WebDriverOptions webDriverOptions;

}
