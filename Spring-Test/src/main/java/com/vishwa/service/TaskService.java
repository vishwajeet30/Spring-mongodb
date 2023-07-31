package com.vishwa.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishwa.model.Task;
import com.vishwa.repository.TaskRepository;



@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    //CRUD  CREATE , READ , UPDATE , DELETE


    public Task addTask(Task task) {
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(task);
    }

    public List<Task> findAllTasks() {
        return repository.findAll();
    }

    public Task getTaskByTaskId(String taskId){
        return repository.findById(taskId).get();
    }

    public List<Task> getTaskByMass(int mass){
        return  repository.findByMass(mass);
    }

    public List<Task> getTaskByName(String name){
        return repository.getTasksByName(name);
    }

    public List<Task> getTaskByDensity(int density){
        return  repository.findByDensity(density);
    }
    
    public Task updateTask(Task taskRequest){
    																															//get the existing document from DB
        																												// populate new value from request to existing object/entity/document
        Task existingTask = repository.findById(taskRequest.getTaskId()).get();
        existingTask.setDescription(taskRequest.getDescription());
        existingTask.setMass(taskRequest.getMass());
        existingTask.setName(taskRequest.getName());
        existingTask.setDensity(taskRequest.getDensity());
        return repository.save(existingTask);
    }

    public String deleteTask(String taskId){
        repository.deleteById(taskId);
        return taskId+" task deleted from dashboard ";
    }
}
