package org.example.capstoneproject.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.capstoneproject.dto.request.LoginRequest;
import org.example.capstoneproject.dto.request.RegisterRequest;
import org.example.capstoneproject.dto.response.AuthResponse;
import org.example.capstoneproject.entity.User;
import org.example.capstoneproject.service.AuthenticationService;
import org.example.capstoneproject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        AuthResponse response = authenticationService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(@Valid @RequestBody LoginRequest request) {
        AuthResponse response = authenticationService.authenticate(request);
        System.out.println(response.getToken() + "\n" + response.getUsername());
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public List<User> welcomePage(){
        return userService.findALl();
    }

}