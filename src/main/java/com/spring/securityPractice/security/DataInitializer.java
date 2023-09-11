package com.spring.securityPractice.security;

import com.spring.securityPractice.entity.RoleEntity;
import com.spring.securityPractice.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.Optional;

@Service
public class DataInitializer {

    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    public void initialize() {
        createRoleIfNotExists("user");
        createRoleIfNotExists("admin");
    }

    private void createRoleIfNotExists(String roleName) {
        Optional<RoleEntity> existingRole = roleRepository.findByRoleName(roleName);
        if (existingRole.isEmpty()) {
            RoleEntity role = new RoleEntity();
            role.setRoleName(roleName);
            roleRepository.save(role);
        }
    }
}
