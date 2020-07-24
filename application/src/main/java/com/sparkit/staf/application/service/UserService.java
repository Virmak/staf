package com.sparkit.staf.application.service;

import com.sparkit.staf.application.models.request.CreateUserRequest;
import com.sparkit.staf.application.models.response.GetUserResponse;
import com.sparkit.staf.domain.user.Role;
import com.sparkit.staf.domain.user.RoleName;
import com.sparkit.staf.domain.user.User;
import com.sparkit.staf.persistence.RoleRepository;
import com.sparkit.staf.persistence.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(RoleRepository roleRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public User createUser(CreateUserRequest createUserRequest) {
        User user = modelMapper.map(createUserRequest, User.class);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Set<String> strRoles = createUserRequest.getRoles();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            if ("admin".equals(role)) {
                Role adminRole = roleRepository.findByName(RoleName.ADMIN)
                        .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                roles.add(adminRole);
            } else {
                Role userRole = roleRepository.findByName(RoleName.USER)
                        .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                roles.add(userRole);
            }
        });

        user.setRoles(roles);
        userRepository.save(user);
        return user;
    }

    public List<GetUserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new GetUserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getName(), user.getRoles()))
                .collect(Collectors.toList());
    }
}
