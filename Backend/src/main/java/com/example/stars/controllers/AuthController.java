package com.example.stars.controllers;

import com.example.stars.dto.UserDTO;
import com.example.stars.exceptions.RegistrationException;
import com.example.stars.models.Users;
import com.example.stars.service.UserRegistrationService;
import com.example.stars.utils.UserValidator;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRegistrationService userRegistrationService;
    private final ModelMapper modelMapper;
    private final UserValidator userValidator;

    @Autowired
    public AuthController(UserRegistrationService userRegistrationService, ModelMapper modelMapper, UserValidator userValidator) {
        this.userRegistrationService = userRegistrationService;
        this.modelMapper = modelMapper;
        this.userValidator = userValidator;
    }

    @GetMapping("login")
    public ResponseEntity<String> loginPage(){
        return ResponseEntity.ok("Login page");
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> login() {
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication != null && authentication.isAuthenticated()) {
//            return ResponseEntity.ok("Login successful");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
//        }
//    }


    @GetMapping("/registration")
    public ResponseEntity<String> registrationPage() {
        return ResponseEntity.ok("auth/registration");
    }


    @PostMapping("/registration")
        public ResponseEntity<String> performRegistration(@Valid @RequestBody UserDTO userDTO,
                                                          BindingResult bindingResult) {
            userValidator.validate(userDTO, bindingResult);

            if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
                bindingResult.rejectValue("confirmPassword", "passwords.mismatch", "Пароли не совпадают");
            }

            if (bindingResult.hasErrors()) {
                return ResponseEntity.badRequest().body("Произошли ошибки проверки");
            }

            try {
                userRegistrationService.register(convertToUser(userDTO));
                return ResponseEntity.ok("Регистрация прошла успешно");
            } catch (RegistrationException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        }

    private Users convertToUser(UserDTO userDTO){
        return modelMapper.map(userDTO,Users.class);
    }

}
