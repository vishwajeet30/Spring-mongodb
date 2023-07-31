package com.vishwa.repository;

import java.util.List;
import com.vishwa.model.Task;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface TaskRepository extends MongoRepository<Task,String> {

    List<Task> findByMass(int mass);
    
    List<Task> findByDensity(int density);

    @Query("{ name: ?0 }")
    List<Task> getTasksByName(String name);
}
