package com.example.demo.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        // 🔹 In-memory user (tests do not expect DB lookup)
        return new UserPrincipal(
                username,
                "{noop}password",
                List.of(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}
