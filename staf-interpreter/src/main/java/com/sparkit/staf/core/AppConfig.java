package com.sparkit.staf.core;

import com.sparkit.staf.core.runtime.config.JsonStafProjectConfig;
import com.sparkit.staf.core.runtime.interpreter.StafFileCompiler;
import com.sparkit.staf.core.runtime.loader.IStafCompiler;
import com.sparkit.staf.core.runtime.loader.IStafConfig;
import com.sparkit.staf.core.runtime.loader.TestSuiteRunner;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.Beta;
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
    public IStafConfig stafConfig() {
        return new JsonStafProjectConfig();
    }

    @Bean
    public IStafCompiler stafFileReader() {
        return new StafFileCompiler();
    }

    @Beta
    TestSuiteRunner testLoader() {
        return new TestSuiteRunner();
    }
}
