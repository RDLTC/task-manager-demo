package com.example.rudy.taskmanagerdemo.controller;

import com.example.rudy.taskmanagerdemo.dto.TaskDto;
import com.example.rudy.taskmanagerdemo.dto.UserDto;
import com.example.rudy.taskmanagerdemo.service.TaskService;
import com.example.rudy.taskmanagerdemo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final UserService userService;
    
    @GetMapping
    public String redirectToUserTasks(Authentication auth){
        String username = auth.getName();
        return "redirect:/tasks/"+username;
    }
    
    @GetMapping("/{username}")
    public String userTasksPage(@PathVariable String username, Model model){
        UserDto user = userService.findByUsername(username);
        model.addAttribute("tasks", user.getTasks());
        return "tasksIndex";
    }
    
    @GetMapping("/{username}/addTask")
    public String userAddTaskPage(Model model){
        model.addAttribute("task", new TaskDto());
        return "addTask";
    }
    
    @PostMapping("/addTask")
    public String addTask(Authentication auth, @ModelAttribute("task") @Valid TaskDto task, Errors errors) throws Exception{
        if(errors.hasErrors()){
            return "addTask";
        }
        taskService.addTask(task, auth.getName());
        return "redirect:/tasks";
    }
}
