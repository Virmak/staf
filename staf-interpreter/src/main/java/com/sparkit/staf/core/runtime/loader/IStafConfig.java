package com.sparkit.staf.core.runtime.loader;

import com.sparkit.staf.core.runtime.loader.exceptions.ConfigFileNotFoundException;

import java.util.List;

public interface IStafConfig {
    public String getProjectName();
    public String getProjectDir();
    public String getProjectDescription();
    public String getReportingDirectory();
    public String getLogDirectory();
    public List<String> testSuites();
    public void readConfigFile(String projectDir, String configFilePath) throws ConfigFileNotFoundException;
}
