package com.example.HomeWork5.controllers;

import com.example.HomeWork5.models.Task;
import com.example.HomeWork5.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task addTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable Task.TaskStatus status) {
        return taskRepository.findByTaskStatus(status);
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        Task existingTask = taskRepository.findById(id).orElse(null);
        if (existingTask != null) {
            existingTask.setTaskStatus(task.getTaskStatus());
            return taskRepository.save(existingTask);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}
