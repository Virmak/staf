package com.sparkit.staf.core.runtime.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparkit.staf.core.runtime.loader.IStafProjectConfigReader;
import com.sparkit.staf.domain.ProjectConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class JsonStafProjectConfig implements IStafProjectConfigReader {
    public static final String DEFAULT_PROJECT_CONFIG_NAME = "config.json";
    private final ObjectMapper mapper;
    @Value("${testDirectory}")
    String testDirectory;

    @Autowired
    public JsonStafProjectConfig(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public ProjectConfig readConfigFile(File configFilePath) throws IOException {
        return mapper.readValue(configFilePath, ProjectConfig.class);
    }
}
