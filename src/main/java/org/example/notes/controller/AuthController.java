package org.example.notes.controller;

import lombok.RequiredArgsConstructor;

import org.example.notes.model.dto.request.AuthRequest;
import org.example.notes.model.dto.request.SignupRequest;
import org.example.notes.service.JwtUtil;
import org.example.notes.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private  final JwtUtil jwtUtil;


    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequest signupRequest) {
        return userService.createUser(signupRequest);
    }

    @PostMapping("/auth")
    public String createAuthenticationToken(@RequestBody AuthRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        return jwtUtil.generateToken(userDetails);
    }
}
