package com.trackApplication.TrackApplication.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trackApplication.TrackApplication.model.ActivityModel;

public interface ActivityRepository extends JpaRepository<ActivityModel, UUID> {
    
}
