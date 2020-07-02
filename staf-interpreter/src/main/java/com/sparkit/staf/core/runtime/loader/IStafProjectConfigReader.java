package com.sparkit.staf.core.runtime.loader;

import com.sparkit.staf.domain.ProjectConfig;

import java.io.IOException;

public interface IStafProjectConfigReader {
    ProjectConfig readConfigFile(String configFilePath) throws IOException;
}
