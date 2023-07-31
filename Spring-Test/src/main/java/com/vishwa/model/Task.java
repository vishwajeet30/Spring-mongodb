package com.vishwa.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.vishwa.model.Task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    private String taskId;
    private String description;
    private int mass;
    private String name;
    private int density;
    
}
