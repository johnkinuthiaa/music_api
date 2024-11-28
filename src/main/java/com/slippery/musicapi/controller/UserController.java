package com.slippery.musicapi.controller;

import com.slippery.musicapi.dto.UserDto;
import com.slippery.musicapi.models.User;
import com.slippery.musicapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/music-app/v1/auth")
public class UserController {
    private final UserService service;
    public UserController(UserService service){
        this.service=service;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDetails){
        return ResponseEntity.ok(service.register(userDetails));
    }
}
