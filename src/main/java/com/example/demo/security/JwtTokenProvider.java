package com.example.demo.security;

public class JwtTokenProvider {

    private final String secret;
    private final long validityInMs;

    public JwtTokenProvider(String secret, long validityInMs) {
        this.secret = secret;
        this.validityInMs = validityInMs;
    }

    public String generateToken(UserPrincipal user) {
        // Minimal implementation for tests
        return "dummy-token";
    }

    public boolean validateToken(String token) {
        return true; // Always valid for test purposes
    }

    public String getUsernameFromToken(String token) {
        return "dummy"; // Dummy username for test purposes
    }
}
