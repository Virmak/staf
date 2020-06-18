package com.sparkit.staf.core;

import com.sparkit.staf.core.runtime.config.JsonStafProjectConfig;
import com.sparkit.staf.core.runtime.interpreter.StafFileCompiler;
import com.sparkit.staf.core.runtime.loader.IStafCompiler;
import com.sparkit.staf.core.runtime.loader.IStafConfig;
import com.sparkit.staf.core.runtime.loader.TestContainer;
import com.sparkit.staf.core.runtime.loader.TestSuiteRunner;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.Beta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
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

    @Bean
    TestContainer testContainer() {
        return new TestContainer();
    }
}
