package com.sparkit.staf.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.sparkit.staf.*",})
public class StafWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(StafWebApplication.class, args);
	}

}
