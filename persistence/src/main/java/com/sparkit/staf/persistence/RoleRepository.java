package com.sparkit.staf.persistence;

import com.sparkit.staf.domain.user.Role;
import com.sparkit.staf.domain.user.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByName(RoleName roleName);
}
