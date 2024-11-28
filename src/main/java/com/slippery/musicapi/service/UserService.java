package com.slippery.musicapi.service;

import com.slippery.musicapi.dto.UserDto;

public interface UserService {
    UserDto login(UserDto userDetails);
    UserDto register(UserDto userDetails);
}
