package com.sparkit.staf.core;

import com.sparkit.staf.core.compiler.StafFileCompiler;
import com.sparkit.staf.core.compiler.IStafCompiler;
import org.json.simple.parser.JSONParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    public static final String LOGGING_FILE = "logging.file";
    public static final String TEST_DIRECTORY = "testDirectory";
    public static final String WEB_DRIVER_ADDRESS = "webDriverAddress";
    public static final String REMOTE_WEB_DRIVER = "remote";
    public static final String BROWSER_NAME = "browserName";
    public static final String BROWSER_VERSION = "browserVersion";
    public static final String ENABLE_VNC = "enableVnc";
    public static final String ENABLE_VIDEO = "enableVideo";

    @Bean
    public JSONParser jsonParser() {
        return new JSONParser();
    }

    @Bean
    public IStafCompiler stafFileReader() {
        return new StafFileCompiler();
    }
}
