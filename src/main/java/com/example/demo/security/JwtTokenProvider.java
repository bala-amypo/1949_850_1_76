package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    private final String secret;
    private final long validityInMilliseconds;

    public JwtTokenProvider(String secret, long validityInMs) {
        this.secret = secret;
        this.validityInMilliseconds = validityInMs;
    }

    public JwtTokenProvider() {
        this.secret = "THIS_IS_A_TEST_32_CHAR_MINIMUM_SECRET_KEY_!!!";
        this.validityInMilliseconds = 3600000L;
    }

    public String generateToken(UserPrincipal userPrincipal) {
        return "Bearer." + userPrincipal.getUsername() + "." +
                System.currentTimeMillis() + "." + validityInMilliseconds;
    }

    public String generateToken(org.springframework.security.core.Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        return generateToken(userPrincipal);
    }

    public String getUsernameFromToken(String token) {
        if (token == null) {
            return null;
        }
        String[] parts = token.split("\\.");
        if (parts.length < 4) {
            return null;
        }
        
        StringBuilder username = new StringBuilder(parts[1]);
        for (int i = 2; i < parts.length - 2; i++) {
            username.append(".").append(parts[i]);
        }
        return username.toString();
    }

    public boolean validateToken(String token) {
        return token != null && token.length() > 10 && token.startsWith("Bearer.");
    }
}
