package com.example.rudy.taskmanagerdemo.controller;

import com.example.rudy.taskmanagerdemo.dto.UserDto;
import com.example.rudy.taskmanagerdemo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/register")
@RequiredArgsConstructor
public class UserRegisterController {
    private final UserService userService;
    
    @GetMapping
    public String userRegisterPage(){
        return "register";
    }
    
    @PostMapping
    public String registerUser(@ModelAttribute @Valid UserDto user, Errors errors){
        if(errors.hasErrors()){
            return "register";
        }
        userService.registerUser(user);
        return "redirect:/login";
    }
}
