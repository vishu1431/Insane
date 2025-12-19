package com.insane.controller;

import com.insane.dto.LoginRequestDto;
import com.insane.dto.LoginResponseDto;
import com.insane.dto.RefreshTokenRequestDto;
import com.insane.service.AuthService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;
    private final PasswordEncoder encoder;

    
    public AuthController(AuthService service, PasswordEncoder encoder) {
        this.service = service;
        this.encoder = encoder;
    }

    
    @PostMapping("/encode-test")
    public String encodeTest() {
        return encoder.encode("test123");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @Valid @RequestBody LoginRequestDto dto) {

        return ResponseEntity.ok(service.login(dto));
    }

    @PostMapping("/refresh")
    public ResponseEntity<LoginResponseDto> refresh(
            @RequestBody RefreshTokenRequestDto dto) {

        return ResponseEntity.ok(service.refreshToken(dto));
    }
    
}
