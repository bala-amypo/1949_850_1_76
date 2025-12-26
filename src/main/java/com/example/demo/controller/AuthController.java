package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.CustomUserDetailsService;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.security.UserPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    private final CustomUserDetailsService userDetailsService;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    public AuthController(CustomUserDetailsService userDetailsService, 
                         JwtTokenProvider jwtTokenProvider,
                         AuthenticationManager authenticationManager) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest request) {
        userDetailsService.register(request.getEmail(), request.getPassword(), "COMPLIANCE_OFFICER");
        UserPrincipal userPrincipal = new UserPrincipal(request.getEmail(), "COMPLIANCE_OFFICER");
        String token = jwtTokenProvider.generateToken(userPrincipal);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        userDetailsService.register(request.getEmail(), request.getPassword(), "COMPLIANCE_OFFICER");
        UserPrincipal userPrincipal = new UserPrincipal(request.getEmail(), "COMPLIANCE_OFFICER");
        String token = jwtTokenProvider.generateToken(userPrincipal);
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
