package com.vishwa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vishwa.model.Task;
import com.vishwa.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task){
        return service.addTask(task);
    }

    @GetMapping
    public List<Task> getTasks() {
        return service.findAllTasks();
    }


    @GetMapping("/{taskId}")
    public Task getTask(@PathVariable String taskId){
        return service.getTaskByTaskId(taskId);
    }

    @GetMapping("/mass/{mass}")
    public List<Task> findTaskUsingMass(@PathVariable int mass){
        return service.getTaskByMass(mass);
    }

    @GetMapping("/name/{name}")
    public List<Task> getTaskByName(@PathVariable String name){
        return service.getTaskByName(name);
    }
    @GetMapping("/density/{density}")
    public List<Task> getTaskByUsingStoryPoint(@PathVariable int density){
        return service.getTaskByDensity(density);
    }

    @PutMapping
    public Task modifyTask(@RequestBody Task task){
        return service.updateTask(task);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable String taskId){
        return service.deleteTask(taskId);
    }
}
