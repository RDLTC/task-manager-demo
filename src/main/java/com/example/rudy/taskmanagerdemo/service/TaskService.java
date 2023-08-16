package com.example.rudy.taskmanagerdemo.service;

import com.example.rudy.taskmanagerdemo.domain.Task;
import com.example.rudy.taskmanagerdemo.domain.User;
import com.example.rudy.taskmanagerdemo.repository.TaskRepository;
import com.example.rudy.taskmanagerdemo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskService {
    private final UserService userService;
    private final TaskRepository taskRepository;
    
    public void addTask(Task task, String username){
        User user = userService.findByUsername(username);
        task.setUser(user);
        taskRepository.save(task);
    }
}
