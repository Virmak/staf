package com.sparkit.staf.core;

import com.sparkit.staf.core.runtime.config.JsonStafConfig;
import com.sparkit.staf.core.runtime.interpreter.StafFileReader;
import com.sparkit.staf.core.runtime.loader.IStafConfig;
import com.sparkit.staf.core.runtime.loader.IStafFileReader;
import com.sparkit.staf.core.runtime.loader.TestContainer;
import com.sparkit.staf.core.runtime.loader.TestLoader;
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
        return new JsonStafConfig();
    }

    @Bean
    public IStafFileReader stafFileReader() {
        return new StafFileReader();
    }

    @Beta
    TestLoader testLoader() {
        return new TestLoader(stafConfig(), stafFileReader());
    }

    @Bean
    TestContainer testContainer() {
        return new TestContainer();
    }
}
