package com.example.rudy.taskmanagerdemo.mapper;

import com.example.rudy.taskmanagerdemo.domain.Task;
import com.example.rudy.taskmanagerdemo.dto.TaskDto;
import lombok.Builder;

@Builder
public class TaskMapper {
    
    public TaskDto taskToDto(Task task){
        TaskDto taskDto = TaskDto.builder()
                                 .title(task.getTitle())
                                 .description(task.getDescription())
                                 .status(task.getStatus())
                                 .createdOn(task.getCreatedOn())
                                 .updatedOn(task.getUpdatedOn())
                                 .build();
        return taskDto;
    }
    
    public Task dtoToTask(TaskDto taskDto){
        Task task = Task.builder()
                        .title(taskDto.getTitle())
                        .description(taskDto.getDescription())
                        .status(taskDto.getStatus())
                        .createdOn(taskDto.getCreatedOn())
                        .updatedOn(taskDto.getUpdatedOn())
                        .build();
        return task;
    }
}
