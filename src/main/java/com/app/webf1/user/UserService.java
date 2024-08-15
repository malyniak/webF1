package com.app.webf1.user;

import com.app.webf1.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).map(user -> new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.singleton(new SimpleGrantedAuthority(user.getRole().name())))).orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " not found"));
    }

    public List<com.app.webf1.user.User> findAll() {
        return userRepository.findAll();
    }

    public void create(UserDto userDto) {
        var user = userMapper.toEntity(userDto);
        Optional.ofNullable(userDto.getPassword()).filter(StringUtils::isNotEmpty).map(new BCryptPasswordEncoder()::encode).ifPresent(user::setPassword);
        userRepository.save(user);
    }

    public User findById(Long id) {
      return   userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User with id " + id + " not found"));
    }
}
