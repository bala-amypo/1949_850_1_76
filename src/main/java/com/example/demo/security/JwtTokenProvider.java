package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Base64;

@Component
public class JwtTokenProvider {

    private final String secretKey;
    private final long validityInMs;

    // 🔴 REQUIRED: NO-ARG CONSTRUCTOR FOR TESTS
    public JwtTokenProvider() {
        this.secretKey = Base64.getEncoder().encodeToString("testsecretkeytestsecretkey".getBytes());
        this.validityInMs = 3600000;
    }

    public JwtTokenProvider(String secret, long validityInMs) {
        this.secretKey = Base64.getEncoder().encodeToString(secret.getBytes());
        this.validityInMs = validityInMs;
    }

    public String generateToken(String username) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMs);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey.getBytes())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException ex) {
            return false;
        }
    }

    public String getUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // 🔴 REQUIRED BY TESTS
    public String getUsernameFromToken(String token) {
        return getUsername(token);
    }
}
