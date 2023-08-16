package com.example.rudy.taskmanagerdemo;

import com.example.rudy.taskmanagerdemo.domain.Status;
import com.example.rudy.taskmanagerdemo.domain.Task;
import com.example.rudy.taskmanagerdemo.domain.User;
import com.example.rudy.taskmanagerdemo.repository.TaskRepository;
import com.example.rudy.taskmanagerdemo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskmanagerDemoApplication implements CommandLineRunner {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public TaskmanagerDemoApplication(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }
    
    public static void main(String[] args) {
        SpringApplication.run(TaskmanagerDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.findAll().isEmpty()){
            User user = User.builder()
                            .email("admin@example.com")
                            .userName("admin")
                            .password("admin96")
                            .rol("ADMIN")
                            .build();
            userRepository.save(user);
            
            Task task1 = new Task();
            task1.setTitle("Task1");
            task1.setDescription("This is task1");
            task1.setStatus(Status.ONGOING);
            task1.setUser(userRepository.findByUserName("admin").get());
            taskRepository.save(task1);
            
            Task task2 = new Task();
            task2.setTitle("Task2");
            task2.setDescription("This is task2");
            task2.setStatus(Status.ONGOING);
            task2.setUser(userRepository.findByUserName("admin").get());
            taskRepository.save(task2);
        }
    }
}
