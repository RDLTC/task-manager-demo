package com.example.rudy.taskmanagerdemo.service;

import com.example.rudy.taskmanagerdemo.domain.Task;
import com.example.rudy.taskmanagerdemo.dto.TaskDto;
import com.example.rudy.taskmanagerdemo.dto.UserDto;
import com.example.rudy.taskmanagerdemo.mapper.TaskMapper;
import com.example.rudy.taskmanagerdemo.mapper.UserMapper;
import com.example.rudy.taskmanagerdemo.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserService userService;
    private final TaskMapper taskMapper;
    private final UserMapper userMapper;
    
    public void addTask(TaskDto task, String username) throws Exception{
        UserDto user = userService.findByUsername(username);
        Task newTask = taskMapper.dtoToTask(task);
        
        newTask.setUser(userMapper.dtoToUser(user));
        taskRepository.save(newTask);
    }
}
