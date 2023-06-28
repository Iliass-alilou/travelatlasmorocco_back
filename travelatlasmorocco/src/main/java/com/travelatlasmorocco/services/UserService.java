package com.travelatlasmorocco.services;

import com.travelatlasmorocco.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto getUser(String email);
    UserDto createUser(UserDto userDto) ;
    UserDto getUserById(String userId);
}
