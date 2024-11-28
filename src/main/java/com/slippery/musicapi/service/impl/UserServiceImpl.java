package com.slippery.musicapi.service.impl;

import com.slippery.musicapi.dto.UserDto;
import com.slippery.musicapi.models.User;
import com.slippery.musicapi.repository.UserRepository;
import com.slippery.musicapi.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
    public UserServiceImpl(UserRepository repository){
        this.repository=repository;

    }
    @Override
    public UserDto login(UserDto userDetails) {
        return null;
    }

    @Override
    public UserDto register(UserDto userDetails) {
        UserDto response =new UserDto();
        User existingUser =repository.findByUsername(userDetails.getUsername());

        try{
            if(existingUser == null){
                User user =new User();
                user.setEmail(userDetails.getEmail());
                user.setUsername(userDetails.getUsername());
                user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
                user.setRole(userDetails.getRole());
                user.setPlaylists(null);
                repository.save(user);
                response.setMessage("User "+userDetails.getUsername()+" was saved successfully");
                response.setStatusCode(200);
            }

        } catch (Exception e) {
            response.setError("User "+userDetails.getUsername()+" cannot be saved right now!");
            response.setMessage(e.getMessage());
            response.setStatusCode(401);
        }
        return response;
    }
}
