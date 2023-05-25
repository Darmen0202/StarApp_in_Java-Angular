package com.example.stars.utils;

import com.example.stars.dto.UserDTO;
import com.example.stars.service.CustomUsersDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    private final CustomUsersDetailsService customUsersDetailsService;

    @Autowired
    public UserValidator(CustomUsersDetailsService customUsersDetailsService) {
        this.customUsersDetailsService = customUsersDetailsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;

        try {
            customUsersDetailsService.loadUserByUsername(userDTO.getUsername());
        } catch (UsernameNotFoundException ignored){
            return;
        }
        errors.rejectValue("login","","Человек с таким логином не существует!");
    }
}
