package com.trackApplication.TrackApplication.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trackApplication.TrackApplication.model.ActivityModel;

import jakarta.transaction.Transactional;

public interface ActivityRepository extends JpaRepository<ActivityModel, UUID> {
    
    @Transactional
    @Modifying
    @Query("SELECT a from ActivityModel a WHERE a.isDone = FALSE")
    List<ActivityModel> findPendingActivities();

    @Transactional
    @Modifying
    @Query("UPDATE ActivityModel a SET a.isDone = TRUE WHERE a.id = :id")
    int markActivityDone(@Param("id") UUID id);
}
