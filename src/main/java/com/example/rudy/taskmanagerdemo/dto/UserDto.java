package com.example.rudy.taskmanagerdemo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    @Email
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String userName;
    private List<TaskDto> tasks;
}
