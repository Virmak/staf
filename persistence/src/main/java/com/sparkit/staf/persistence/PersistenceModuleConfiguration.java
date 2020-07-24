package com.sparkit.staf.persistence;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan
@EnableJpaRepositories("com.sparkit.staf.persistence")
public class PersistenceModuleConfiguration {
}
