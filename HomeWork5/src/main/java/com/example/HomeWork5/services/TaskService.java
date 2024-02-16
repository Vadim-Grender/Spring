package com.example.HomeWork5.services;

import com.example.HomeWork5.models.Task;
import com.example.HomeWork5.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task addTask(String taskName, String taskDescription) {
        Task task = new Task();
        return taskRepository.save(task);
    }

    public void removeTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }
}
