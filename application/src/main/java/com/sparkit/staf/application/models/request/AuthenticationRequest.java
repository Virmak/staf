package com.sparkit.staf.application.models.request;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;
    private String password;
}
