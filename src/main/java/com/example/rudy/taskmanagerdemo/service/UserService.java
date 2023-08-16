package com.example.rudy.taskmanagerdemo.service;

import com.example.rudy.taskmanagerdemo.domain.User;
import com.example.rudy.taskmanagerdemo.dto.UserDto;
import com.example.rudy.taskmanagerdemo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService{
    
    private final UserRepository userRepository;
    //private final UserMapper mapper;
    
    public void registerUser(UserDto user){
        //User newUser = mapper.dtoToUser(user);
        User newUser = User.builder()
                        .email(user.getEmail())
                        .userName(user.getUserName())
                        .password(user.getPassword())
                        .rol("USER")
                        .build();
        userRepository.save(newUser);
    }
    
    public User findByUsername(String username){
        User user = userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("Username "+username+" not found."));
        return user;
    }
    
}