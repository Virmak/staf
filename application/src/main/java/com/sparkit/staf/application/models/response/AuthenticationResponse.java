package com.sparkit.staf.application.models.response;

import com.sparkit.staf.domain.user.Role;
import lombok.Data;

import java.util.Set;

@Data
public class AuthenticationResponse {
    private String token;
    private Long id;
    private String username;
    private String email;
    private String name;
    private Set<Role> roles;
}
