package com.trackApplication.TrackApplication.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trackApplication.TrackApplication.model.ActivityModel;
import com.trackApplication.TrackApplication.repository.ActivityRepository;

@Service
public class ActivityServices {

    @Autowired
    private ActivityRepository activityRepository;

    public List<ActivityModel> getAllActivities() {
        return activityRepository.findAll();
    }

    public List<ActivityModel> getPendingActivities() {
        return activityRepository.findPendingActivities();
    }

    public ActivityModel addActivity(ActivityModel activity) {
        return activityRepository.save(activity);
    }

    public Optional<ActivityModel> markActivityDone(UUID id) {
        activityRepository.markActivityDone(id);
        Optional<ActivityModel> activityModel = activityRepository.findById(id);
        return activityModel;
    }

    public UUID deleteActivity(UUID id) {
        activityRepository.deleteById(id);
        return id;
    }
    
}
