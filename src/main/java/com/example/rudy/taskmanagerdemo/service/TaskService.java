package com.example.rudy.taskmanagerdemo.service;

import com.example.rudy.taskmanagerdemo.domain.Task;
import com.example.rudy.taskmanagerdemo.domain.User;
import com.example.rudy.taskmanagerdemo.dto.TaskDto;
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
        User user = userMapper.mapToUser(userService.findByUsername(username));
        
        Task newTask = taskMapper.mapToTask(task);
        newTask.setUser(user);
        
        taskRepository.save(newTask);
    }
}
