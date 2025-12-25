package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class CustomUserDetailsService {

    private final Map<String, UserPrincipal> users = new HashMap<>();
    private final AtomicLong idGen = new AtomicLong(1);

    public UserPrincipal register(String email, String password, String role) {
        UserPrincipal user = new UserPrincipal(
                idGen.getAndIncrement(),
                email,
                password,
                role
        );
        users.put(email, user);
        return user;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!users.containsKey(username)) {
            throw new UsernameNotFoundException("User not found");
        }
        return users.get(username);
    }
}
