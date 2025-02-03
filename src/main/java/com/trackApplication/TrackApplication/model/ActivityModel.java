package com.trackApplication.TrackApplication.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "activites")
public class ActivityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
    @Column(name = "id", columnDefinition = "uuid")
    public UUID id;
    String task;
    String description;
    public ActivityModel(String task, String description) {
        this.task = task;
        this.description = description;
    }
    public String getTask() {
        return task;
    }
    public void setTask(String task) {
        this.task = task;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public ActivityModel() {
        this.id = UUID.randomUUID();  // Manually generate the UUID
    }
}