package com.example.demo.security;

import java.util.HashMap;
import java.util.Map;

public class CustomUserDetailsService {
    private Map<String, UserPrincipal> users = new HashMap<>();
    private long idGen = 1;

    public UserPrincipal register(String username, String password, String role) {
        UserPrincipal user = new UserPrincipal(idGen++, username);
        users.put(username, user);
        return user;
    }

    public UserPrincipal loadUserByUsername(String username) {
        return users.get(username);
    }
}
