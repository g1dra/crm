package com.g1dra.crm.configuration;

import com.g1dra.crm.factories.TaskFactory;
import com.g1dra.crm.factories.UserFactory;
import com.g1dra.crm.models.Task;
import com.g1dra.crm.models.User;
import com.g1dra.crm.repositories.TaskRepository;
import com.g1dra.crm.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TaskConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            TaskRepository taskRepository,
            UserRepository userRepository
    ) {
        return args -> {
              List<Task> taskList = TaskFactory.create(10);
             taskRepository.saveAll(taskList);
             List<User> userList = UserFactory.create(10);
             userRepository.saveAll(userList);
        };
    }
}
