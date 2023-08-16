package com.example.rudy.taskmanagerdemo.mapper;

import com.example.rudy.taskmanagerdemo.domain.User;
import com.example.rudy.taskmanagerdemo.dto.UserDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserMapper {
    private final TaskMapper taskMapper;
    
    public UserDto userToDto(User user){
        UserDto userDto = UserDto.builder()
                                 .email(user.getEmail())
                                 .tasks(user.getTasks().stream().map(taskMapper::taskToDto).toList())
                                 .build();
        
        return userDto;
    }
    
    public User dtoToUser(UserDto userDto){
        User user = User.builder()
                        .email(userDto.getEmail())
                        .tasks(userDto.getTasks().stream().map(taskMapper::dtoToTask).toList())
                        .build();
        return user;
    }
}
