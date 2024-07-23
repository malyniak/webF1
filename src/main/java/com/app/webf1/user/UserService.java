package com.app.webf1.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userRepository.findByUsername(username);
        return  userRepository.findByUsername(username)
//                .map(user -> new UserDto(
//                        user.getUsername(),
//                        user.getEmail(),
//                        user.getPhoneNumber(),
//                        user.getPassword(),
//                        user.getRole()
//                ))
                .map(user -> new User (
                        user.getUsername(),
                        user.getPassword(),
                        Collections.singleton(user.getRole())
                ))
                .orElseThrow(() -> new UsernameNotFoundException("User with name" + username + "not found"));
    }
}
