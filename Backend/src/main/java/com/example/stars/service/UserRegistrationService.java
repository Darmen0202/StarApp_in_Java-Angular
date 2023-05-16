package com.example.stars.service;

import com.example.stars.enums.UsersRole;
import com.example.stars.mappers.UserMapper;
import com.example.stars.models.Users;
import com.example.stars.utils.UserValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRegistrationService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserRegistrationService(UserMapper userMapper,PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(UsersRole.USER.getRole());
        userMapper.register(user);
    }

}
