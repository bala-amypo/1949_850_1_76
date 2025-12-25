package com.example.demo.security;

import java.util.HashMap;
import java.util.Map;

public class CustomUserDetailsService {

    private Map<String, UserPrincipal> users = new HashMap<>();
    private long idGen = 1L;

    public UserPrincipal register(String email, String password, String role) {
        UserPrincipal user = new UserPrincipal(idGen++, email);
        users.put(email, user);
        return user;
    }

    public UserPrincipal loadUserByUsername(String username) {
        return users.get(username);
    }
}

