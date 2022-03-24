package com.example.demo.controller;

import com.example.demo.model.JWTRequest;
import com.example.demo.model.JWTResponse;
import com.example.demo.service.AuthenticationAuthorizationService;
import com.example.demo.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/login")
public class AunthenticationAuthorizationController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private JWTRequest jwtRequest;

    @Autowired
    private AuthenticationAuthorizationService authenticationAuthorizationService;


    @PostMapping("/login")
    public ResponseEntity<JWTResponse> authenticate(@RequestBody JWTRequest jwtRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword()));
        } catch (BadCredentialsException ex) {
            throw new Exception("Invalid credentials", ex);
        }

        final JWTRequest jwtRequest = jwtRequest.loadUserByUsername(jwtRequest.getEmail());

        final String token = jwtUtility.generateToken(userDetails);
        return ResponseEntity.status(HttpStatus.OK).body(new JWTResponse(token));
    }

}
