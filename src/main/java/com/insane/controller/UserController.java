package com.insane.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insane.dto.UserRequestDto;
import com.insane.dto.UserResponseDto;
import com.insane.entity.LoginUser;
import com.insane.repository.LoginUserRepository;
import com.insane.service.UserServiceImpl;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    
    private final LoginUserRepository userRepo;

    public UserController(LoginUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto dto) {
        return ResponseEntity.ok(userService.createUser(dto));
    }
    
    @GetMapping
    public ResponseEntity<List<LoginUser>> getAllUsers() {

        List<LoginUser> users = userRepo.findAll();
        return ResponseEntity.ok(users);
    }
    

   
}