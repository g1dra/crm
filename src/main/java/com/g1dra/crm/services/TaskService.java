package com.g1dra.crm.services;

import com.g1dra.crm.models.Task;
import com.g1dra.crm.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void addNewTask(Task task) {
        taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    public Optional<Task> find(Long taskId) {
        return taskRepository.findById(taskId);
    }

    public void updateTask(Task task, Long id) {
       Optional<Task> oldTask = taskRepository.findById(id);
       if(oldTask.isPresent()) {
           taskRepository.save(task);
       }
       else {
           throw new IllegalStateException("Invalid Task Id");
       }

    }
}
