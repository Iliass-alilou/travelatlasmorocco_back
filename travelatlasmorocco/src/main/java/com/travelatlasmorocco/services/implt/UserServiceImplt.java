package com.travelatlasmorocco.services.implt;

import java.util.ArrayList;

import com.travelatlasmorocco.entities.UserEntity;
import com.travelatlasmorocco.repositories.UserRepository;
import com.travelatlasmorocco.services.UserService;
import com.travelatlasmorocco.shared.Utils;
import com.travelatlasmorocco.shared.dto.UserDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.User;

@Service
public class UserServiceImplt implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils util;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDto getUser(String email) {

        UserEntity userEntity = userRepository.findByEmail(email);

        if (userEntity == null)
            throw new UsernameNotFoundException(email);

        UserDto userDto = new UserDto();

        BeanUtils.copyProperties(userEntity, userDto);

        return userDto;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        // check exiting user
        UserEntity checkExisting_User = userRepository.findByEmail(userDto.getEmail());

        if (checkExisting_User != null)
            throw new RuntimeException("user already exist !");

        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);

        userEntity.setEcryptyPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userEntity.setUserId(util.generatedValue(32));

        UserEntity newUser = userRepository.save(userEntity);

        UserDto userDto1 = modelMapper.map(newUser, UserDto.class);
        return userDto1;
    }

    @Override
    public UserDto getUserById(String userId) throws UsernameNotFoundException{
        UserEntity userEntity = userRepository.findByUserId(userId);
        if (userEntity == null)
            throw new UsernameNotFoundException(userId);
        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = modelMapper.map(userEntity,UserDto.class);
        return userDto;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByEmail(email);

        if (userEntity == null)
            throw new UsernameNotFoundException(email);
        return new User(userEntity.getEmail(), userEntity.getEcryptyPassword(), new ArrayList<>());
    }
}
