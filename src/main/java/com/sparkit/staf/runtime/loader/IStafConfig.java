package com.sparkit.staf.runtime.loader;

import com.sparkit.staf.runtime.loader.exceptions.ConfigFileNotFoundException;

import java.util.List;

public interface IStafConfig {
    public String getProjectName();
    public String getProjectDescription();
    public String getReportingDirectory();
    public String getTestDirectory();
    public String getLogDirectory();
    public List<String> testSuites();
    public void readConfig(String configFilePath) throws ConfigFileNotFoundException;
}
