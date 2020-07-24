package com.sparkit.staf.api.controllers;

import com.sparkit.staf.api.security.jwt.JwtProvider;
import com.sparkit.staf.api.security.services.UserPrincipal;
import com.sparkit.staf.application.models.request.AuthenticationRequest;
import com.sparkit.staf.application.models.response.AuthenticationResponse;
import com.sparkit.staf.application.models.response.GenericResponse;
import com.sparkit.staf.core.utils.SharedConstants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtProvider jwtProvider, ModelMapper modelMapper) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/auth/sign-in")
    public ResponseEntity<AuthenticationResponse> authenticateUser(@Valid @RequestBody AuthenticationRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        AuthenticationResponse response = modelMapper.map(userPrincipal, AuthenticationResponse.class);
        response.setToken(jwt);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/ping")
    public GenericResponse ping() { // used to test if token is valid
        return new GenericResponse(SharedConstants.OK_RESULT_STRING);
    }
}
