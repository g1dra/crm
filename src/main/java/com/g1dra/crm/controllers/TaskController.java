package com.g1dra.crm.controllers;

import com.g1dra.crm.models.Task;
import com.g1dra.crm.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Optional<Task> find(Long id) {
        return taskService.find(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void add(@Valid @RequestBody Task task) {
        taskService.addNewTask(task);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{taskId}")
    public void delete(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Task task, @PathVariable Long id ) {
        taskService.updateTask(task, id);
    }
}
