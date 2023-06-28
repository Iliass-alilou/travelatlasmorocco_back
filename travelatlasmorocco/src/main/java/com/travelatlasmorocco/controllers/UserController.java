package com.travelatlasmorocco.controllers;

import com.travelatlasmorocco.exceptions.UserException;
import com.travelatlasmorocco.requests.UserRequest;
import com.travelatlasmorocco.responses.ErrorMessages;
import com.travelatlasmorocco.responses.UserResponse;
import com.travelatlasmorocco.services.UserService;
import com.travelatlasmorocco.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String id){
        UserDto userDto = userService.getUserById(id);
        ModelMapper modelMapper = new ModelMapper();
        UserResponse userResponse = modelMapper.map(userDto, UserResponse.class);
        return new ResponseEntity<UserResponse>(userResponse,HttpStatus.ACCEPTED.CREATED);
    }
    @PostMapping
    public ResponseEntity<UserResponse> CreatUser(@RequestBody UserRequest userRequest)
            throws Exception {
        if(userRequest.getFirstName().isEmpty()) {
            throw new UserException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        }

        //UserDto userDto = new UserDto();
        //BeanUtils.copyProperties(userRequest, userDto);
        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = modelMapper.map(userRequest, UserDto.class);

        UserDto createUser = userService.createUser(userDto);

        UserResponse userResponse = modelMapper.map(createUser, UserResponse.class);

        return   new ResponseEntity<UserResponse>(userResponse, HttpStatus.ACCEPTED.CREATED);
    }
}
