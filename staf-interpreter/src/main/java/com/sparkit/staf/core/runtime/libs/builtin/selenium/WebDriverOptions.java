package com.sparkit.staf.core.runtime.libs.builtin.selenium;

import lombok.Data;

@Data
public class WebDriverOptions {
    private String webDriverAddress;
    private String browserName;
    private String browserVersion;
    private boolean remote;
    private boolean enableVnc;
    private boolean enableVideo;
    private int sessionCount;
}
