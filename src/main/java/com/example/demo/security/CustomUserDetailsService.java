package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private Map<String, UserPrincipal> users = new HashMap<>();
    private long nextId = 1;
    
    public UserPrincipal register(String email, String password, String role) {
        if (users.containsKey(email)) {
            throw new UsernameNotFoundException("User already exists");
        }
        UserPrincipal user = new UserPrincipal(nextId++, email, role);
        users.put(email, user);
        return user;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPrincipal user = users.get(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return user;
    }
}
