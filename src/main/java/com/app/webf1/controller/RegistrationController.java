package com.app.webf1.controller;

import com.app.webf1.user.UserDto;
import com.app.webf1.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final UserService userService;


    @PostMapping
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserDto userDto) {
        userService.create(userDto);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }
}
