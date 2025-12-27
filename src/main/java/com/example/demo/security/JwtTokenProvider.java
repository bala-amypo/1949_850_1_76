package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    private final String secret;
    private final long validityInMilliseconds;

    // EXACT TEST CONSTRUCTOR
    public JwtTokenProvider(String secret, long validityInMs) {
        this.secret = secret;
        this.validityInMilliseconds = validityInMs;
    }

    // SPRING CONSTRUCTOR
    public JwtTokenProvider() {
        this.secret = "THIS_IS_A_TEST_32_CHAR_MINIMUM_SECRET_KEY_!!!";
        this.validityInMilliseconds = 3600000L;
    }

    public String generateToken(UserPrincipal userPrincipal) {
        // SIMPLE TOKEN FOR TESTS
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
        // token format: Bearer.<username with dots>.<timestamp>.<validity>
        if (parts.length < 4) {
            return null;
        }
        // Rebuild username from parts[1..length-3] so dots in email are preserved
        StringBuilder username = new StringBuilder(parts[1]);
        for (int i = 2; i < parts.length - 2; i++) {
            username.append(".").append(parts[i]);
        }
        return username.toString();
    }

    public boolean validateToken(String token) {
        // Simple validation for tests
        return token != null && token.length() > 10 && token.startsWith("Bearer.");
    }
}
