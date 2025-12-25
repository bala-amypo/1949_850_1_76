package com.example.demo.security;

public class JwtTokenProvider {
    public String generateToken(UserPrincipal user) {
        return "dummy-token";
    }
    public boolean validateToken(String token) { return true; }
    public String getUsernameFromToken(String token) { return "dummy"; }
}
