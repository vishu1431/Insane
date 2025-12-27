package com.insane.controller;

import com.insane.dto.LoginRequestDto;
import com.insane.dto.LoginResponseDto;
import com.insane.dto.RefreshTokenRequestDto;
import com.insane.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
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
    	log.info("Password encode endpoint hit");
        return encoder.encode("test123");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @Valid @RequestBody LoginRequestDto dto) {
    	 log.info("Login request received for user: {}", dto.getUsername());

         LoginResponseDto response = service.login(dto);

         log.info("Login successful for user: {}", dto.getUsername());
         log.debug("Token generated: {}", response.getAccessToken());

        return ResponseEntity.ok(service.login(dto));
        
        
    }
    

   @PostMapping("/refresh")
    public ResponseEntity<LoginResponseDto> refresh(
            @RequestBody RefreshTokenRequestDto dto) {

    	  log.info("Refresh token request received");

          LoginResponseDto response = service.refreshToken(dto);

          log.info("Access token refreshed successfully");
    	
        return ResponseEntity.ok(service.refreshToken(dto));
    }
    
    
}
