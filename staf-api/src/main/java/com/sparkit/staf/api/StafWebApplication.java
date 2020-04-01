package com.sparkit.staf.api;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.sparkit.staf.*",})
public class StafWebApplication {

	public static void main(String[] args) {
		if (args.length > 0) {
			System.setProperty("testDirectory", args[0]);
		}
		SpringApplication.run(StafWebApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
