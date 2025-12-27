package com.insane.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.insane.dto.LoginRequestDto;
import com.insane.dto.LoginResponseDto;
import com.insane.dto.RefreshTokenRequestDto;
import com.insane.entity.LoginUser;
import com.insane.entity.RefreshToken;
import com.insane.repository.LoginUserRepository;
import com.insane.repository.RefreshTokenRepository;
import com.insane.security.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthService {

    private final LoginUserRepository userRepo;
    private final RefreshTokenRepository refreshRepo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthService(LoginUserRepository userRepo,
                       RefreshTokenRepository refreshRepo,
                       PasswordEncoder encoder,
                       JwtUtil jwtUtil) {
        this.userRepo = userRepo;
        this.refreshRepo = refreshRepo;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    // ================= LOGIN =================
    public LoginResponseDto login(LoginRequestDto dto) {

        LoginUser user = userRepo.findByUsername(dto.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username"));

        if (!encoder.matches(dto.getPassword(), user.getPasswordHash())) {
            throw new RuntimeException("Invalid password");
        }

        String accessToken = jwtUtil.generateToken(user.getUsername());

        RefreshToken refresh = new RefreshToken();
        refresh.setUser(user);
        refresh.setRefreshToken(UUID.randomUUID().toString());
        refresh.setExpiresAt(LocalDateTime.now().plusDays(7));

        refreshRepo.save(refresh);

        LoginResponseDto response = new LoginResponseDto();
        response.setAccessToken(accessToken);
        response.setTokenType("Bearer");
        response.setRefreshToken(refresh.getRefreshToken());
        response.setExpiresIn(1000);

        return response;
    }

    // ================= REFRESH TOKEN =================
    public LoginResponseDto refreshToken(RefreshTokenRequestDto dto) {

        RefreshToken token = refreshRepo
                .findByRefreshTokenAndIsRevokedFalse(dto.getRefreshToken())
                .orElseThrow(() -> new RuntimeException("Invalid refresh token"));

        if (token.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Refresh token expired");
        }

        // revoke old token
        token.setIsRevoked(true);
        refreshRepo.save(token);

        // generate new access token
        String newAccessToken =
                jwtUtil.generateToken(token.getUser().getUsername());

        // create new refresh token
        RefreshToken newRefresh = new RefreshToken();
        newRefresh.setUser(token.getUser());
        newRefresh.setRefreshToken(UUID.randomUUID().toString());
        newRefresh.setExpiresAt(LocalDateTime.now().plusDays(7));

        refreshRepo.save(newRefresh);

        LoginResponseDto response = new LoginResponseDto();
        response.setAccessToken(newAccessToken);
        response.setTokenType("Bearer");
        response.setRefreshToken(newRefresh.getRefreshToken());
        response.setExpiresIn(1000);

        return response;
    }
}
