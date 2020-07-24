package com.sparkit.staf.application.models.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
public class CreateUserRequest {
    private String email;
    @NotEmpty
    private String username;
    @NotEmpty
    private String name;
    @NotEmpty
    private String password;
    private Set<String> roles;
}
