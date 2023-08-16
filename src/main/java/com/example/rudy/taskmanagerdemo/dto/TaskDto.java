package com.example.rudy.taskmanagerdemo.dto;

import com.example.rudy.taskmanagerdemo.domain.Status;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private Status status;
    private LocalDate createdOn;
    private LocalDate updatedOn;
}
