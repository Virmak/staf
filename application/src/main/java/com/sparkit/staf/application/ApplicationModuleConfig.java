package com.sparkit.staf.application;


import com.sparkit.staf.persistence.PersistenceModuleConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({PersistenceModuleConfiguration.class})
public class ApplicationModuleConfig {
}
