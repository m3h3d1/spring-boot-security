package com.spring.securityPractice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private long id;
    private String userId;
    private String email;
    private String password;
    private String token;
    private Set<String> roles;
}