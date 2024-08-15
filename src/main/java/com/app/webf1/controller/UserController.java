package com.app.webf1.controller;


import com.app.webf1.user.User;
import com.app.webf1.user.UserDto;
import com.app.webf1.user.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('DEV', 'ADMIN')")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id,
                                        @CurrentSecurityContext SecurityContext securityContext,
                                        @AuthenticationPrincipal UserDetails userDetails) {
        logger.debug("Fetching user by id: {}", id);
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        logger.debug("Fetching all users");
        return ResponseEntity.ok(userService.findAll());
    }

    @PutMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        userService.create(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }
}