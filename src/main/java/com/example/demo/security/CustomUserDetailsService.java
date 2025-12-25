package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;
import java.util.Map;

public class CustomUserDetailsService {

    private final Map<String, UserPrincipal> users = new HashMap<>();
    private long sequence = 1L;

    public UserPrincipal register(String email, String password, String role) {

        UserPrincipal user = new UserPrincipal();
        user.setId(sequence++);
        user.setUsername(email);
        user.setRole(role);

        users.put(email, user);
        return user;
    }

    public UserDetails loadUserByUsername(String username) {
        return users.get(username);
    }
}
