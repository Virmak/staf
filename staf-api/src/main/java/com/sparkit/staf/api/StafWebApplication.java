package com.sparkit.staf.api;

import com.sparkit.staf.application.models.request.CreateUserRequest;
import com.sparkit.staf.application.service.UserService;
import com.sparkit.staf.domain.user.Role;
import com.sparkit.staf.domain.user.RoleName;
import com.sparkit.staf.persistence.PersistenceModuleConfiguration;
import com.sparkit.staf.persistence.RoleRepository;
import com.sparkit.staf.persistence.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.util.Collections;

@SpringBootApplication
@ComponentScan({"com.sparkit.staf.*", "com.sparkit.staf.persistence", "com.sparkit.staf.domain"})
@EntityScan("com.sparkit.staf.*")
@Import({PersistenceModuleConfiguration.class})
public class StafWebApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserService userService;

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

    @Override
    public void run(String... args) throws Exception {
        if (!roleRepository.findByName(RoleName.ADMIN).isPresent()) {
            Role adminRole = new Role();
            adminRole.setName(RoleName.ADMIN);
        }
        if (!roleRepository.findByName(RoleName.USER).isPresent()) {
            Role userRole = new Role();
            userRole.setName(RoleName.USER);
        }
        if (!userRepository.findByUsername("admin").isPresent()) {
            CreateUserRequest createUserRequest = new CreateUserRequest();
            createUserRequest.setEmail("admin@staf.com");
            createUserRequest.setUsername("admin");
            createUserRequest.setName("Admin user");
            createUserRequest.setPassword("00000000");
            createUserRequest.setRoles(Collections.singleton("admin"));
            userService.createUser(createUserRequest);
        }
    }
}
