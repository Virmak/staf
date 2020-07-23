package com.sparkit.staf.application.models.response;

import com.sparkit.staf.domain.user.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserResponse {
    private Long id;
    private String username;
    private String email;
    private String name;
    private Set<Role> roles;
}
